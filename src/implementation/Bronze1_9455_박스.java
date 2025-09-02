package implementation;

import java.util.Scanner;

public class Bronze1_9455_박스 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();

        for(int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split(" ");

            int vertical = Integer.parseInt(input[0]); // 5
            int horizontal = Integer.parseInt(input[1]); // 4

            int[][] box = new int[horizontal][vertical]; // 5 4
            int sum = 0;

            for(int j = 0; j < vertical; j++) {
                String[] row = scan.nextLine().split(" "); // 1 0 0 0
                for(int k = 0; k < horizontal; k++) {
                    box[k][j] = Integer.parseInt(row[k]);
                }
            }

            for(int o = 0; o < horizontal; o++) {
                for(int p = 0; p < vertical; p++) {
                    int plus = 1;
                    for(int m=1; m < vertical-p; m++) {
                        if(box[o][p] == 1 && box[o][p+plus] == 0) {
                            sum++;
                        }
                        plus++;
                    }

                }
            }
            System.out.println(sum);
        }

    }
}
