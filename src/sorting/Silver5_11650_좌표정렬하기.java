package sorting;

import java.io.*;
import java.util.*;

public class Silver5_11650_좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int[][] position = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            position[i][0] = Integer.parseInt(input[0]);
            position[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(position, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p1[0] - p2[0];
            } else {
                return p1[1] - p2[1];
            }
        });

        for (int i = 0; i < t; i++) {
            bw.append(String.valueOf(position[i][0]));
            bw.append(" ");
            bw.append(String.valueOf(position[i][1]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
