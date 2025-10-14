package inbox;

import java.util.Scanner;

public class Bronze1_1546_평균 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        scan.nextLine();

        double[] scores = new double[t];

        String[] input = scan.nextLine().split(" ");
        for (int i = 0; i < t; i++) {
            scores[i] = Integer.parseInt(input[i]);
        }

        double maxScore = 0;
        for (int i = 0; i < t; i++) {
            if(maxScore < scores[i]) {
                maxScore = scores[i];
            }
        }

        double sum = 0;
        for (int i = 0; i < t; i++) {
            sum += (scores[i] / maxScore * 100);
//            System.out.println(scores[i] / maxScore * 100);
        }

        System.out.println(sum / t);
    }
}
