package math;

import java.util.Scanner;

public class Silver5_24228_젓가락 {
    public static void main(String[] args) {

        /*
        접근 방법
        - 5종류의 젓가락이 있고, 3개의 짝을 맞춰야 한다고 가정했을 때,
            최악의 경우는 A,B,C,D는 하나씩만 나오고 나머지는 모두 E 젓가락이 6개 나오는 경우이며 총 10번 뽑아야한다.
        - 따라서 (R * 2) + (N - 1) 이 정답이다
         */

        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        long N = Long.parseLong(input[0]);
        long R = Long.parseLong(input[1]);

        System.out.println((R*2) + (N-1));
    }
}
