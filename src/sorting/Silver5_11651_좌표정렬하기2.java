package sorting;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Silver5_11651_좌표정렬하기2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scan.nextInt();
        scan.nextLine();

        int[][] arr = new int[t][2];
        for (int i = 0; i < t; i++) {
            String[] input = scan.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(arr, (p1, p2) -> {
            if (p1[1] == p2[1]) {
                return p1[0] - p2[0];
            } else {
                return p1[1] - p2[1];
            }
        });

        for (int i = 0; i < t; i++) {
            bw.append(String.valueOf(arr[i][0]));
            bw.append(" ");
            bw.append(String.valueOf(arr[i][1]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
