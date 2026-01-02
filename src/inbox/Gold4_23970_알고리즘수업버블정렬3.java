package inbox;

import java.io.*;

public class Gold4_23970_알고리즘수업버블정렬3 {

    /*
    접근 방법
    1. 정렬을 진행하기 전 일치하는 숫자의 count를 기록한다.
    1. 버블 정렬을 진행하며 바뀔 때마다 count 값을 갱신한다.
    3. count 값이 전체 length와 같아지면 1을 출력, 아니라면 0을 출력한다.
     */

    /*
    책임 분리
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 정렬을 하는 bubbleSort 메서드
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

        int count = 0;

        for(int i =0; i < arrA.length; i++) {
            if(arrA[i] == arrB[i]) {
                count++;
            }
        }

        if(count == arrA.length) {
            return true;
        }


        for(int i = 0; i < arrA.length; i++) {
            for(int j = 0; j < arrB.length -1 -i; j++) {
                if(arrA[j] > arrA[j+1]) {
                    if(arrA[j] == arrB[j]) {
                        count--;
                    }
                    if(arrA[j+1] == arrB[j+1]) {
                        count--;
                    }

                    int tmp = arrA[j];
                    arrA[j] = arrA[j+1];
                    arrA[j+1] = tmp;

                    if(arrA[j] == arrB[j]) {
                        count++;
                    }
                    if(arrA[j+1] == arrB[j+1]) {
                        count++;
                    }
                }
                if(count == arrA.length) {
                    return true;
                }
            }
        }
        return false;
    }
}



