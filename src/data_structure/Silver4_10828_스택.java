package data_structure;

import java.util.Scanner;

class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private StackNode head;
    private int count;

    public Stack() {
        head = null;
        count = 0;
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = head;
        head = newNode;
        count++;
    }

    public int pop() {
        if(count == 0) {
            return -1;
        } else {
            int popData = head.data;
            head = head.next;
            count--;
            return popData;
        }
    }

    public int size() {
        return count;
    }

    public int empty() {
        if(count == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int top() {
        if(count == 0) {
            return -1;
        } else {
            return head.data;
        }
    }

}

public class Silver4_10828_스택 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();

        Stack stack = new Stack();

        for (int i = 0; i < t; i++) {
            String input = scan.nextLine();
            if(input.contains("push")) {
                String[] tmp = input.split(" ");
                int data = Integer.parseInt(tmp[1]);
                stack.push(data);
            }
            if(input.equals("pop")) {
                System.out.println(stack.pop());
            }
            if(input.equals("size")) {
                System.out.println(stack.size());
            }
            if(input.equals("empty")) {
                System.out.println(stack.empty());
            }
            if(input.equals("top")) {
                System.out.println(stack.top());
            }
        }

    }
}
