package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Silver5_7568_덩치 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        scan.nextLine();

        int[] kg = new int[t];
        int[] cm = new int[t];

        for (int i = 0; i < t; i++) {
            String[] input = scan.nextLine().split(" ");
            kg[i] = Integer.parseInt(input[0]);
            cm[i] = Integer.parseInt(input[1]);
        }

        int[] rank = new int[t];
        Arrays.fill(rank, 1);

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {

                if(i == j) {
                    continue;
                }
                if(kg[j] < kg[i] && cm[j] < cm[i]) {
                    rank[j]++;
                }
            }
        }

        for (int i = 0; i < t-1; i++) {
            System.out.print(rank[i] + " ");
        }
        System.out.print(rank[t-1]);
    }
}
