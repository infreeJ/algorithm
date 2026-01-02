package sorting;

import java.io.*;

public class Bronze1_23969_알고리즘수업버블정렬2 {

    /*
    접근 방법
    1. 버블 정렬을 진행한다.
    2. 각 진행 횟수에 따라 count 값을 증가시킨다.
    3. count 값이 K와 일치할 때 반복문을 중지시키고 배열을 출력한다.
     */

    /*
    책임 분배
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 정렬을 하는 bubbleSort 메서드
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        boolean isSuccess = bubbleSort(arr, K);

        if(isSuccess) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println(-1);
        }

    }

    static boolean bubbleSort(int[] arr, int K) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    count++;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }

                if(count == K) {
                    return true;
                }
            }
        }
        return false;
    }
}




