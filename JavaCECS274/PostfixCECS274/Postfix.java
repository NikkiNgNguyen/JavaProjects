/* Nikki Nguyen
CECS 274
Prog 4 - RPN Equation
November 8, 2016
 */


import java.util.*;

public class Postfix {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        HashSet operators = new HashSet();
        operators.add('-');
        operators.add('+');
        operators.add('^');
        operators.add('*');
        operators.add('/');
        String equation;
        String postfix;
        System.out.println("Enter an equation: ");
        equation = scan.nextLine();
        for(int i = 0; i < equation.length(); i++) {
        	char c = equation.charAt(i);
        	if (c == '0' || c == '1' || c== '2' || c == '3' || c == '4' || c == '5'
        		|| c == '6' || c == '7' || c == '8' || c == '9') {
					System.out.print(c);
			} else if (operators.contains(c) && (stack.isEmpty() || stack.peek() == '(')) {
				stack.push(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty()) {
					char n = stack.pop();
					if (n == ')') {
						break;
					} else if (operators.contains(n)) {
						System.out.print(n);
					}
				}
			} else if (c == '^' && !stack.isEmpty()) {
				if (stack.peek() == '-' || stack.peek() == '+' || stack.peek() == '*'
					|| stack.peek() == '/') {
					stack.push(c);
				} else if (c == '^') {
					char n = stack.pop();
					System.out.print(n);
					stack.push(c);
				}
			} else if ((c == '*' || c == '/') && !stack.isEmpty()) {
				if (stack.peek() == '-' || stack.peek() == '+') {
					stack.push(c);
				} else if (stack.peek() == '*' || stack.peek() == '/') {
					char n = stack.pop();
					System.out.print(n);
					stack.push(c);
				} else if (stack.peek() == '^') {
					while(!stack.isEmpty() && stack.peek() == '^') {
						System.out.print(stack.pop());
					} if (stack.isEmpty()) {
						stack.push(c);
					}
				}
			} else if ((c == '+' || c == '-') && !stack.isEmpty()) {
				if (stack.peek() == '^' || stack.peek() == '*' || stack.peek() == '/') {
					while(!stack.isEmpty() && (stack.peek() == '^' || stack.peek() == '*' || stack.peek() == '/')) {
						System.out.print(stack.pop());
					} if (stack.isEmpty()) {
						stack.push(c);
					}
				} else if (stack.peek() == '+' || stack.peek() == '-') {
					char n = stack.pop();
					System.out.print(n);
					stack.push(c);
				}
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
    }
}
