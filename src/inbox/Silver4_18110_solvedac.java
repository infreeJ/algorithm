package inbox;

import java.util.*;
import java.io.*;

public class Silver4_18110_solvedac {

    /*
    접근 방법
    1. 입력을 배열로 받고 오름차순 정렬한다.
    2. 절사평균을 구하기 위해 제외해야하는 수를 구하고 최저값, 최대값을 각각 제외한다.
    3. 제외하고 남은 값들의 평균을 구한다.
     */

    /*
    책임 분리
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 정렬된 배열에서 제외되는 수를 제외한 배열을 반환하는 excludeArray 메서드
    3. 최종 배열의 평균값을 구하는 getAverage 메서드
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int exceptionNum = (int)(Math.round(n * 0.15));

        int answer = getAverage(arr, exceptionNum);
        System.out.println(answer);

    }

    static int getAverage(int[] arr, int exceptionNum) {
        int sum = 0;
        for(int i = exceptionNum; i < arr.length-exceptionNum; i++) {
            sum += arr[i];
        }
        double average = (double) sum / (arr.length - (exceptionNum * 2));

        return (int) Math.round(average);
    }
}
