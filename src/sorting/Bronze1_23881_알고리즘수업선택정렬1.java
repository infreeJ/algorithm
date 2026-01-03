package sorting;

import java.util.*;
import java.io.*;

public class Bronze1_23881_알고리즘수업선택정렬1 {

    /*
    접근 방법
    1. 배열을 순환하며 가장 큰 수를 찾아서 끝 인덱스부터 채운다.
    2. 교환이 발생할 때마다 count 값을 증가시킨다.
    3. count가 K와 일치할 때의 두 값을 출력한다.
     */

    /*
    책임 분리
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 선택 정렬을 하는 selectionSort 메서드
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        int[] answer = selectionSort(arr, K);
        if(answer[0] != 0 || answer[1] != 0) {
            Arrays.sort(answer);

            System.out.print(answer[0] + " ");
            System.out.print(answer[1]);
        } else {
            System.out.print(-1);
        }
    }

    static int[] selectionSort(int[] arr, int K) {

        int count = 0;
        int[] answer = new int[2];
        for(int i = arr.length-1; i > 0; i--) {
            int pointer = i;
            for(int j = i-1; j >= 0; j--) {
                if(arr[pointer] < arr[j]) {
                    pointer = j;
                }
            }

            if(arr[pointer] != arr[i]) {
                count++;
                int tmp = arr[pointer];
                arr[pointer] = arr[i];
                arr[i] = tmp;
                if(count == K) {
                    answer[0] = arr[i];
                    answer[1] = arr[pointer];
                }
            }

        }

        return answer;
    }
}
