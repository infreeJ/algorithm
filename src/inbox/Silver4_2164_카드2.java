package inbox;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Silver4_2164_카드2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        scan.nextLine();

        Queue<Integer> queue = new LinkedList<>();


        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            if(queue.size() > 1) {
                queue.add(queue.poll());
            }
        }

        System.out.println(queue.peek());
    }
}
