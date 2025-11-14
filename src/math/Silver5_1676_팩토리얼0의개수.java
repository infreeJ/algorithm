package math;

import java.util.Scanner;

public class Silver5_1676_팩토리얼0의개수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int count = 0;

        while (N >= 5) {
            count += N/5;
            N /= 5;
        }

        System.out.println(count);

//        long sum = 1;
//        for (int i = 1; i <= N; i++) {
//            sum *= i;
//        }
//
//        String sumStr = String.valueOf(sum);
//        System.out.println(sum);
//        int p = sumStr.length()-1;
//        int count = 0;
//        while (p >= 0 && sumStr.charAt(p) == '0') {
//            count++;
//            p--;
//        }
//
//        System.out.println(count);


    }
}
