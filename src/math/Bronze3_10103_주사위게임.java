package math;

import java.util.Scanner;

public class Bronze3_10103_주사위게임 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        scan.nextLine();


        int chang = 100;
        int sang = 100;


        for (int i = 0; i < t; i++) {
            String[] input = scan.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if(a > b) {
                sang -= a;
            } else if (a < b) {
                chang -= b;
            }
        }

        System.out.println(chang);
        System.out.println(sang);
    }
}
