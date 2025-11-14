package implementation;

import java.util.Scanner;

public class Bronze4_11720_숫자의합 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        scan.nextLine();

        String[] input = scan.nextLine().split("");

        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += Integer.parseInt(input[i]);
        }

        System.out.println(sum);
    }
}
