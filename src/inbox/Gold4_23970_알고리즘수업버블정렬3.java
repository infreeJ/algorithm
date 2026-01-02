package inbox;

import java.io.*;
import java.util.*;

public class Gold4_23970_알고리즘수업버블정렬3 {

    /*
    접근 방법
    1. 버블 정렬을 진행한다.
    2. 교환이 발생할 때마다 바뀐 부분을 비교한다.
    3. 바뀐 부분이 일치할 때만 전체를 Arrays.equals로 비교한다.
    4. 일치한다면 정렬을 중지하고 1, 아니라면 0을 출력한다.
     */

    /*
    책임 분리
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 정렬을 하는 bubbleSort 메서드
    3. 일치하는지 체크하는 checkArr 메서드
     */

    /*
    자꾸 시간초과가 난다.
    Arrays.equals은 O(2n) 으로 예상된다.
    버블 정렬은 O(n^2)
    매 교환마다 검증하면 O(n^3)이 된다.
    교환이 일어난 부분만 검증한다면?
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arrA = new int[N];
        int[] arrB = new int[N];

        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");

        for(int i = 0; i < arrA.length; i++) {
            arrA[i] = Integer.parseInt(inputA[i]);
            arrB[i] = Integer.parseInt(inputB[i]);
        }

        if(bubbleSort(arrA, arrB)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static boolean bubbleSort(int[] arrA, int[] arrB) {

        if(Arrays.equals(arrA, arrB)) {
            return true;
        }


        for(int i = 0; i < arrA.length; i++) {
            for(int j = 0; j < arrB.length -1 -i; j++) {
                if(arrA[j] > arrA[j+1]) {
                    int tmp = arrA[j];
                    arrA[j] = arrA[j+1];
                    arrA[j+1] = tmp;

                    if(checkArr(arrA, arrB, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean checkArr(int[] arrA, int[] arrB, int j) {
        if(arrA[j] == arrB[j] && arrA[j+1] == arrB[j+1]) {
            return Arrays.equals(arrA, arrB);
        }
        return false;
    }
}



