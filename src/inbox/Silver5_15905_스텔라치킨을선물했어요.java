package inbox;

import java.io.*;
import java.util.*;

public class Silver5_15905_스텔라치킨을선물했어요 {
    /*
    접근 방법
    1. 입력을 받아 List<Integer[]>에 담는다.
        - 2차원 배열을 사용하는 이유는 패널티 값의 범위가 0 ~ 100,000으로 크기때문에 시간복잡도가 더 낮은 Collections를 사용하기 위함
    2. Collections.sort(() -> ...)를 사용하여 정렬한다.
    3. 5번 학생의 문제 풀이 수를 저장하고 문제 풀이 수가 다른 학생이 나올때까지 List를 순환하며 count 값을 증가시킨다.
     */

    /*
    책임 분배
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 정렬하는 listSort 메서드
    3. 아쉽게 수상하지 못한 학생의 수를 반환하는 getChickenNum 메서드
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        List<Integer[]> list = new ArrayList<>();

        for(int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            Integer[] intArr = new Integer[2];
            intArr[0] = Integer.parseInt(input[0]);
            intArr[1] = Integer.parseInt(input[1]);
            list.add(intArr);
        }

        listSort(list);

        int chickenNum = getChickenNum(list);

        System.out.println(chickenNum);
    }

    static void listSort(List<Integer[]> list) {
        Collections.sort(list, (arr1, arr2) -> {
            if(!arr1[0].equals(arr2[0])) {
                return arr2[0] - arr1[0];
            } else {
                return arr1[1] - arr2[1];
            }
        });
    }

    static int getChickenNum(List<Integer[]> list) {
        if(list.size() <= 5) {
            return 0;
        }
        int standardScore = list.get(4)[0];
        int chickenNum = 0;

        for(int i = 5; i < list.size(); i++) {
            if(standardScore == list.get(i)[0]) {
                chickenNum++;
            } else {
                return chickenNum;
            }
        }
        return chickenNum;
    }
}






