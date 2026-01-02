package sorting;

import java.io.*;
import java.util.*;

public class Silver5_15905_스텔라치킨을선물했어요 {
    /*
    접근 방법
    1. 입력을 받아 2차원 배열에 담는다.
    2. Arrays.sort()를 사용하여 정렬한다.
    3. 5번 학생의 문제 풀이 수를 저장하고 문제 풀이 수가 다른 학생이 나올때까지 array를 순환하며 count 값을 증가시킨다.
     */

    /*
    책임 분배
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 정렬하는 arraySort 메서드
    3. 아쉽게 수상하지 못한 학생의 수를 반환하는 getChickenNum 메서드
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[][] array = new int[t][2];

        for(int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int[] intArr = new int[2];
            intArr[0] = Integer.parseInt(input[0]);
            intArr[1] = Integer.parseInt(input[1]);
            array[i] = intArr;
        }

        arraySort(array);

        int chickenNum = getChickenNum(array);

        System.out.println(chickenNum);
    }

    static void arraySort(int[][] array) {
        Arrays.sort(array, (arr1, arr2) -> {
            if(arr1[0] != (arr2[0])) {
                return arr2[0] - arr1[0];
            } else {
                return arr1[1] - arr2[1];
            }
        });
    }

    static int getChickenNum(int[][] array) {
        if(array.length <= 5) {
            return 0;
        }
        int standardScore = array[4][0];
        int chickenNum = 0;

        for(int i = 5; i < array.length; i++) {
            if(standardScore == array[i][0]) {
                chickenNum++;
            } else {
                return chickenNum;
            }
        }
        return chickenNum;
    }
}






