package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver2_16401_과자나눠주기 {
    public static void main(String[] args) throws IOException {

        /*
        접근 방법

        - 이분 탐색을 응용한 파라메트릭 서치 기법을 사용
        - 탐색 범위: [최소 1cm ~ 가장 긴 과자 길이]
        - mid 값을 정답으로 가정하고 각 과자를 mid로 잘랐을 때
            조카 수보다 많은지 적은지에 따라 탐색 범위를 좁혀나간다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        int M = Integer.parseInt(input1[0]); // 조카의 수
        int N = Integer.parseInt(input1[1]); // 과자의 수

        int[] snacks = new int[N]; // 과자의 길이 배열
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(snacks); // 정렬 필요

        long minSize = 1; // 최소 과자 길이
        long maxSize = snacks[N - 1]; // 최대 과자 길이

        long answer = 0; // 정답

        while (minSize <= maxSize) {
            long mid = minSize + (maxSize - minSize) / 2; // 최소값과 최대값으 중간값(오버플로우를 방지하기 위한 연산)

            // 과자 길이 배열을 순환하며 과자들을 중간값으로 나눴을 때 나오는 과자의 숫자를 구한다.
            long count = 0;
            for(long snack : snacks) {
                count += snack / mid;
            }

            // 이 숫자가 조카 수와 같거나 크다면 모두 나눠줄 수 있기 때문에 정답일 수도 있음
            if(count >= M) {
                answer = mid; // 정답 후보를 해놓고
                minSize = mid+1; // 더 길게 나눠줄 수도 있으니 최소값을 중간값으로 바꿔서 다시 계산
            } else {
                maxSize = mid-1; // 조카 수보다 안나온다면 최대값을 중간값으로 바꿔서 다시 계산
            }
        }

        System.out.println(answer);
    }
}