/*
Nikki Nguyen
CECS 274
Prog 4 - RPN Equation
November 15, 2016
 */

import java.util.*;

public class StacksandQueues {

    static Scanner scan = new Scanner(System.in);
    static opStack node = new opStack(null);
    static ArrayList<String> postFix = new ArrayList<>();

    public static void main(String[] args) {
        String equation;
        boolean validation = false;
        do {
            System.out.println("Enter an infix equation: ");
            equation = scan.nextLine();

            equation = equation.replaceAll("\\+", " + ");

            equation = equation.replaceAll("\\-", " - ");

            equation = equation.replaceAll("\\*", " * ");
            equation = equation.replaceAll("\\/", " / ");
            equation = equation.replaceAll("\\(", " ( ");
            equation = equation.replaceAll("\\)", " ) ");
            equation = equation.replaceAll("\\^", " ^ ");
            String[] token = equation.split("[ ]+");
            validation = toPostFix(token);
        } while (validation == false);
        System.out.print("Postfix: ");
        for (int i = 0; i < postFix.size(); i++) {
            System.out.print(postFix.get(i));
            System.out.print(" ");

        }
        System.out.println("");
        calculate();

    }

    private static boolean toPostFix(String[] token) {
        int cOperator = 0;
        int cOperand = 0;
        int cParen = 0;
        for (int i = 0; i < token.length; i++) {
            //check for the operators
            if (token[i].equals("+") || token[i].equals("-")
                    || token[i].equals("*") || token[i].equals("/")
                    || token[i].equals("(") || token[i].equals(")")
                    || token[i].equals("^")) {
                cOperator++;
                if (token[i].equals("(") || token[i].equals(")")) {
                    cParen--;
                }
                //push if empty
                if (node.isEmpty() == true) {
                    node.push(token[i]);
                    //push if (
                } else if (token[i].equals("(")) {
                    node.push(token[i]);
                    //pop values within ()
                } else if (token[i].equals(")")) {
                    while (!(node.top().equals("("))) {
                        postFix.add(node.pop());
                    }
                    //else pop
                    node.pop();
                    //check precedence
                } else if (node.top().equals("+") || node.top().equals("-") || node.top().equals("(")) {
                    if (node.top().equals("(")) {
                        node.push(token[i]);

                    } else if (token[i].equals("+") || token[i].equals("-")) {

                        postFix.add(node.pop());

                        node.push(token[i]);
                    } else {
                        node.push(token[i]);
                    }
                    //check precedence
                } else if (node.top().equals("*") || node.top().equals("/")) {
                    if (token[i].equals("+") || token[i].equals("-")) {
                        while (node.isEmpty() == false) {
                            postFix.add(node.pop());
                        }
                        node.push(token[i]);
                    } else if (token[i].equals("*") || token[i].equals("/")) {
                        postFix.add(node.pop());
                        node.push(token[i]);
                    } else {
                        node.push(token[i]);
                    }
                } else if (node.top().equals("^")) {
                    postFix.add(node.pop());
                    while (node.isEmpty() == false) {
                        postFix.add(node.pop());
                    }

                    node.push(token[i]);
                }

            } else {
                cOperand++;
                postFix.add(token[i]);
            }
        }

        while (node.isEmpty() == false) {
            if (node.top().equals("(")) {
                continue;
            }
            postFix.add(node.pop());
        }
        int isValid = (cOperand - cOperator) - cParen;

        if (isValid == 1 || isValid == -1) {

            return true;
        } else {
            postFix.clear();
            //System.out.println(cOperator);
            //System.out.println(cOperand);
            token = null;
            System.out.println("Invalid Equation");
            return false;
        }

    }

    static void calculate() {
        opStack num = new opStack(null);
        //end
        double value = 0;
        double right = 0;
        double left = 0;
        for (int i = 0; i < postFix.size(); i++) {
            String newVar = postFix.get(i);
            if (newVar.matches(".*\\d+.*")) {
                //System.out.println("test3");
                num.push(newVar);

            } else {
                right = Double.parseDouble(num.pop());
                left = Double.parseDouble(num.pop());
                switch (postFix.get(i)) {
                    case "+":
                        value = left + right;
                        String value2 = Double.toString(value);
                        //System.out.println(value2);
                        num.push(value2);

                        break;
                    case "-":
                        value = left - right;
                        String value3 = Double.toString(value);
                        //System.out.println(value3);
                        num.push(value3);
                        break;
                    case "*":
                        value = left * right;
                        String value4 = Double.toString(value);
                        //System.out.println(value4);
                        num.push(value4);
                        break;
                    case "/":
                        value = left / right;
                        String value5 = Double.toString(value);
                        //System.out.println(value5);
                        num.push(value5);
                        break;
                    case "^":
                        value = Math.pow(left, right);
                        String value6 = Double.toString(value);
                        //System.out.println(value6);
                        num.push(value6);
                        break;
                    default:
                        System.out.println("inoperable");

                }
            }

        }

        System.out.println("Value: " + value);

    }
