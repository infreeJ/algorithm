package bruteforce;

import java.util.Scanner;

public class Bronze2_2798_블랙잭 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input1 = scan.nextLine().split(" ");

        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        String[] input2 = scan.nextLine().split(" ");
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(input2[i]);
        }

        int sum = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int tmp = cards[i] + cards[j] + cards[k];
                    if(tmp <= m && tmp > sum) {
                        sum = tmp;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
