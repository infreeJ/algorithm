package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze1_2775_부녀회장이될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            System.out.println(count(K, N));
        }
    }

    public static int count(int K, int N) {
        int[] downStairs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] currentStairs = new int[14];

        for (int i = 0; i < K; i++) { // 층 수만큼 올라가면서
            for (int j = 0; j < N; j++) { // 필요한 인원 수를 호실마다 넣는다
                int tmp = 0;
                for (int k = 0; k <= j; k++) { // 필요한 인원 수를 구한다.
                    tmp += downStairs[k];
                }
                currentStairs[j] = tmp;
            }
            downStairs = Arrays.copyOf(currentStairs, currentStairs.length);
        }
        return currentStairs[N-1];
    }
}

