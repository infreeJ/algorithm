package math;

import java.util.Scanner;

public class Bronze3_10818_최소최대 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();

        String[] input = scan.nextLine().split(" ");

        int min = 1000000;
        int max = -1000000;
        for (int i = 0; i < t; i++) {
            if(min > Integer.parseInt(input[i])) {
                min = Integer.parseInt(input[i]);
            }

            if(max < Integer.parseInt(input[i])) {
                max = Integer.parseInt(input[i]);
            }
        }
        System.out.println(min + " " + max);
    }
}
