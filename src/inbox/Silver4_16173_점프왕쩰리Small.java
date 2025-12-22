package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver4_16173_점프왕쩰리Small {

    /*
    접근 방법
    1. 3 이상의 정수가 쓰여진 칸은 무조건 구역 밖으로 떨어지므로 값이 1 또는 2인 칸으로만 진행한다.
    2. 배열의 i, j 인덱스를 파라미터로 받는 재귀함수를 호출하여 탐색한다.
    3. 도달할 수 있다면 HaruHaru 출력. 도달할 수 없다면 Hing 출력
     */

    /*
    책임 분배
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 칸을 탐색하는 search 메서드
     */

    static int[][] square;
    static boolean isSuccess = false;

    public static void main(String[] args) throws IOException {

        // 테스트 케이스 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 정사각형 초기화
        square = new int[t][t];

        // 정사각형 값 입력
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < t; j++) {
                square[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 재귀함수 0, 0으로 시작
        search(0, 0);
        
        // 결과 출력
        if(isSuccess) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }


    /**
     * 정사각형을 탐색하는 메서드
     * - 끝에 도달할 수 있다면 isSuccess를 true로 업데이트한다.
     */
    static void search(int i, int j) {

        // 이미 성공한 상태라면 return
        if(isSuccess) {
            return;
        }

        // 벗어난 인덱스 값일 경우 return
        if(i >= square.length || j >= square.length) {
            return;
        }

        // 현재 칸의 값
        int jump = square[i][j];

        // 2, 2일 경우 isSuccess를 true로 바꾸고 return
        if(jump == -1) {
            isSuccess = true;
            return;
        }

        // jump가 square.length 이상인 경우 무조건 인덱스 밖으로 나간다.
        if (jump >= square.length || jump == 0) {
            return;
        }

        // 다음 포인터
        int nextI = i + jump;
        int nextJ = j + jump;

        // 적절한 인덱스 값인 경우에만 재귀 호출
        if(nextI < square.length) {
            search(nextI, j);
        }
        if(nextJ < square.length) {
            search(i, nextJ);
        }
    }
}
