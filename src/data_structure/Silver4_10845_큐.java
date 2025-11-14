package data_structure;


import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkedListQueue {
    private Node front;
    private Node rear;

    public void push(int item) {
        Node newNode = new Node(item);
        if(rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int pop() {
        if(front == null) {
            return -1;
        }
        int data = front.data;
        front = front.next;

        if(front == null) {
            rear = null;
        }
        return data;
    }

    public int size() {
        if(front == null) {
            return 0;
        }
        Node current = front;
        int count = 0;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public int empty() {
        if(rear == null && front == null) {
            return 1;
        } else {
            return 0;
        }
    }

    public int front() {
        if(front == null) {
            return -1;
        }
        return front.data;
    }

    public int back() {
        if(rear == null) {
            return -1;
        }
        return rear.data;
    }
}

public class Silver4_10845_큐 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedListQueue queue = new LinkedListQueue();
        int t = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < t; i++) {
            String input = scan.nextLine();

            if(input.contains("push")) {
                String[] inputPush = input.split(" ");
                queue.push(Integer.parseInt(inputPush[1]));
            }

            if(input.equals("pop")) {
                System.out.println(queue.pop());
            }

            if(input.equals("size")) {
                System.out.println(queue.size());
            }

            if(input.equals("empty")) {
                System.out.println(queue.empty());
            }

            if(input.equals("front")) {
                System.out.println(queue.front());
            }

            if(input.equals("back")) {
                System.out.println(queue.back());
            }
        }
    }
}









