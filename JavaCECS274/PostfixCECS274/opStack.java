/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NikkiNguyen
 */
public class opStack {

    private String operator;
    private opStack head; //change double to char/string if you want different
    private opStack next;

    public opStack(String lowOperator) {
        head = null;
        operator = lowOperator;
    }
    public String pop() {
        if (isEmpty() == false) {
            String x = head.operator;
            head = head.next;
            return x;
        } else {
            return null;
        }
    }

    public String top() {
        if (isEmpty() == true) {
            return null;
        } else {
            String x = head.operator;
            return x;

        }
    }

    public void push(String lowOperator) {
        opStack temp = new opStack(lowOperator);
        if (isEmpty() == true) {
            head = temp;
            return;
        }
        temp.next = head;
        head = temp;
    }

    public boolean isEmpty() {
        return (head == null);


    }


}
