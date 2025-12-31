package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Silver5_2535_아시아정보올림피아드 {

    /*
    접근 방법
    1. 나라별 받은 메달 수를 체크할 int[]을 선언한다.
    2. Collections.sort를 통해 정렬한다.
    3. 순위를 메긴다.
     */

    /*
    책임 분배
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 메달 수를 체크하는 medalCheck() 메서드
    3. 정렬하는 scopeSort() 메서드
     */


    static int[] award = new int[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 입력을 받을 리스트
        List<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            Integer[] intArr = new Integer[3];
            for (int j = 0; j < 3; j++) {
                intArr[j] = Integer.parseInt(input[j]);
            }
            list.add(intArr);
        }

        // 리스트 정렬
        scopeSort(list);

        int[][] medalLists = new int[3][3];

        int tmp = 0;
        for (int i = 0; i < 3; i++) { // 수상자 3명 뽑아내기
            while(true) { // 수상자 나올때까지 반복
                if(medalCheck(list.get(tmp)[0])) {
                    medalLists[i][0] = list.get(tmp)[0];
                    medalLists[i][1] = list.get(tmp)[1];
                    tmp++;
                    break;
                }
                tmp++;
            }
        }

        for (int i = 0; i < medalLists.length; i++) {
            System.out.println(medalLists[i][0] + " " + medalLists[i][1]);
        }
    }

    /**
     * 리스트 내부의 점수를 이용해 리스트를 내림차순 정렬하는 메소드
     */
    static List<Integer[]> scopeSort(List<Integer[]> list) {
        Collections.sort(list, (a, b) -> {
            return b[2] - a[2];
        });

        return list;
    }

    /**
     * 메달 수상 횟수를 검증하여 2회 미만이라면 true를 반환하는 메소드
     * @param country 나라 번호
     * @return 메달 수상 가능 여부
     */
    static boolean medalCheck(int country) {
        if(award[country] < 2) {
            award[country]++;
            return true;
        }
        return false;
    }

}
