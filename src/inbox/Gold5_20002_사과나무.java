package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold5_20002_사과나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int sum = 0;
        int max = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(arr[i][j] > sum) {
                    sum = arr[i][j];
                }
            }
        }





        System.out.println(max);

    }
}








