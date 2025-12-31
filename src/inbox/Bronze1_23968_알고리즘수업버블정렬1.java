package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze1_23968_알고리즘수업버블정렬1 {

    /*
    접근 방법
    1. 버블 정렬을 구현한다.
    2. 버블 정렬 조건에 따라 값이 바뀔 때마다 count 값을 증가시킨다.
    3. count 값이 K와 같다면 두 수를 출력한다.
     */

    /*
    책임 분배
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 정렬하는 bubbleSort 메서드
     */

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");

        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);
        arr = new int[N];
        String[] input2 = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        // 버블 정렬
        int[] answer = new int[2];
        answer = bubbleSort(K);

        if(answer[0] != 0 && answer[1] != 0) {
            System.out.println(answer[0] + " " + answer[1]);
        } else {
            System.out.println(-1);
        }
    }

    /**
     * 버블 정렬하며 교환 횟수에 일치하는 두 수를 리턴한다.
     * @param K 교환 횟수
     * @return K번째 교환된 두 수
     */
    static int[] bubbleSort(int K) {

        int[] changeNum = new int[2];
        int count = 0;

        for (int i = arr.length-1; i > 0; i--) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    count++;
                    if(K == count) {
                        changeNum[0] = arr[j];
                        changeNum[1] = arr[j+1];
                        Arrays.sort(changeNum);
                        return changeNum;
                    }
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return changeNum;
    }
}












