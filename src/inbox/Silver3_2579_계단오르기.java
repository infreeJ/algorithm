package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3_2579_계단오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 계단의 수
        int[] score = new int[t+1]; // 각 계단의 점수(1번 인덱스부터 사용)
        for (int i = 1; i <= t; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 각 계단까지의 최대값을 담을 배열
        int[] dp = new int[t+1];

        // 1번 계단까지의 최대값은 당연히 1번 계단을 밟는 것
        dp[1] = score[1];

        // 계단이 1개만 있는 경우를 대비한 조건문
        if(t >= 2) {
            dp[2] = score[1] + score[2]; // 계단이 2개일 때 최대값
        }

        // 3번째 계단부터 점화식 적용
        for (int i = 3; i <= t; i++) {
            // i번째 계단의 최대값은 한칸을 넘어서 왔을 때의 최대값과 바로 아래칸에서 왔을 때 중 높은 수
            // 바로 아래칸에서 왔을 경우엔 2칸 밑의 최대값을 + 한다.
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(dp[t]);

    }
}
