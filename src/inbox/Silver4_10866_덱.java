package inbox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Silver4_10866_덱 {

    static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Deque {
        Node front;
        Node rear;
        int size = 0;

        public void push_front(int data) {
            Node newNode = new Node(data);
            if (size == 0) {
                front = newNode;
                rear = newNode;
                size++;
                return;
            }
            front.prev = newNode;
            newNode.next = front;
            front = newNode;
            size++;
        }

        public void push_back(int data) {
            Node newNode = new Node(data);
            if (size == 0) {
                rear = newNode;
                front = newNode;
                size++;
                return;
            }
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
            size++;
        }

        public int pop_front() {
            if (front == null) {
                rear = null;
                return -1;
            }
            int item = front.data;
            front = front.next;
            size--;
            if (size == 0) {
                front = null;
                rear = null;
            }
            return item;
        }

        public int pop_back() {
            if (rear == null) {
                front = null;
                return -1;
            }
            int item = rear.data;
            rear = rear.prev;
            size--;
            if (size == 0) {
                front = null;
                rear = null;
            }
            return item;
        }

        public int size() {
            return size;
        }

        public int empty() {
            if (rear == null) {
                return 1;
            } else {
                return 0;
            }
        }

        public int front() {
            if (front == null) {
                return -1;
            } else {
                return front.data;
            }
        }

        public int back() {
            if (rear == null) {
                return -1;
            } else {
                return rear.data;
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));

        try {

            int t = Integer.parseInt(br.readLine());

            Deque deque = new Deque();

            for (int i = 0; i < t; i++) {
                String input = br.readLine();

                if (input.contains("push_front")) {
                    String[] tmp = input.split(" ");
                    deque.push_front(Integer.parseInt(tmp[1]));
                }

                if (input.contains("push_back")) {
                    String[] tmp = input.split(" ");
                    deque.push_back(Integer.parseInt(tmp[1]));
                }

                if (input.equals("pop_front")) {
                    bw.write(String.valueOf(deque.pop_front()));
                    bw.newLine();
                }

                if (input.equals("pop_back")) {
                    bw.write(String.valueOf(deque.pop_back()));
                    bw.newLine();
                }

                if (input.equals("size")) {
                    bw.write(String.valueOf(deque.size()));
                    bw.newLine();
                }

                if (input.equals("empty")) {
                    bw.write(String.valueOf(deque.empty()));
                    bw.newLine();
                }

                if (input.equals("front")) {
                    bw.write(String.valueOf(deque.front()));
                    bw.newLine();
                }

                if (input.equals("back")) {
                    bw.write(String.valueOf(deque.back()));
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
