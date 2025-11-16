package math;

import java.util.Scanner;

public class Bronze1_25166_배고픈아리의샌드위치구매하기 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int S = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        if(S <= 1023) {
            System.out.println("No thanks");
            return;
        }

        int rest = S - 1023;

        if((M & rest) == rest ) {
            System.out.println("Thanks");
        } else {
            System.out.println("Impossible");
        }

    }
}
