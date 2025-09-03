package bruteforce;

import java.util.Scanner;

public class Bronze1_1356_유진수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("");

        int[] num = new int[input.length];

        for(int i = 0; i < input.length; i++) {
            num[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i < num.length-1; i++) {
            int left = 1;
            int right = 1;
            for(int j = i; j >= 0; j--) {
                left *= num[j]; // 2 *
            }
            for(int k = i+1; k < num.length; k++) {
                right *= num[k];
            }
            //System.out.println(i+1 + "번째 = "+"left="+left+"   right=" + right);
            if(left == right) {
                System.out.println("YES");
                return;
            }

        }
        System.out.println("NO");

    }
}
