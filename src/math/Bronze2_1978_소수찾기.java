package math;

import java.util.Scanner;

public class Bronze2_1978_소수찾기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        scan.nextLine();

        String[] input = scan.nextLine().split(" ");
        int[] num = new int[t];
        for (int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(input[i]);
        }


        int count = 0;
        for (int i = 0; i < t; i++) {
            if(num[i] == 1) {
                continue;
            }
            boolean isTrue = true;
            for (int j = 2; j <= Math.sqrt(num[i]); j++) {
                if(num[i] % j == 0) {
                    isTrue = false;
                    break;
                }
            }
            if(isTrue) {
                count++;
            }
        }

        System.out.println(count);
    }
}
