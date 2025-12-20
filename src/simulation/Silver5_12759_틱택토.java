package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver5_12759_틱택토 {
    /*
     * 접근 방법
     * 1. 3 x 3의 String 배열을 만든다. "O" or "X" or "N"
     * 2. 반복문을 9번 돌면서 입력받은 좌표에 마킹한다.
     *      - O와 X는 prevMark 변수로 관리하여 현재 마킹할 모양을 선택
     * 3. 한번 마킹될 때마다 해당 마킹으로 조건이 충족되는지 검증한다.
     *      3개가 직선으로 이어지는 경우 끝
     * 4. 조건이 충족되면 결과를 출력하고 즉시 종료한다.
     */

    /*
     * 책임 분배
     * 1. 입력을 받고 결과를 출력하는 main 메서드
     * 2. 좌표를 받고 마킹하는 mark 메서드
     * 3. 조건이 충족하는지 검사하는 verification 메서드
     */

    static final String[][] ticTacToe = new String[3][3];

    public static void main(String[] args) throws IOException {

        // 게임판 초기화
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = "N";
            }
        }

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int player = Integer.parseInt(br.readLine());
        
        // 현재 차례의 플레이어가 표시할 마크
        String currentMark = null;
        if(player == 1) {
            currentMark = "O";
        } else {
            currentMark = "X";
        }
        
        for (int i = 0; i < 9; i++) {
            String[] point = br.readLine().split(" ");

            // 마크
            mark(point, currentMark);

            // 승리했는지 검증
            boolean isSuccess = verification(point, currentMark);
            
            // 승리했다면 결과 출력 후 return
            if(isSuccess) {
                int winner = 0;
                if(currentMark.equals("O")) {
                    winner = 1;
                } else {
                    winner = 2;
                }
                System.out.println(winner);
                return;
            }

            // 다음 차례 마크로 변경
            if(currentMark.equals("O")) {
                currentMark = "X";
            } else {
                currentMark = "O";
            }
        }

        // 무승부라면 0 출력
        System.out.println(0);
    }


    /**
     * 좌표를 받고 마킹하는 메서드
     */
    private static void mark(String[] point, String currentMark) {

        int x = Integer.parseInt(point[0]) - 1;
        int y = Integer.parseInt(point[1]) - 1;
        ticTacToe[y][x] = currentMark;
    }


    /**
     * 조건이 충족하는지 검사하는 메서드
     * @return 조건 충족 여부
     */
    private static boolean verification(String[] point, String currentMark) {

        int x = Integer.parseInt(point[0]) - 1;
        int y = Integer.parseInt(point[1]) - 1;

        int count = 0;
        boolean isSuccess = false;

        // 가로 검증
        for (int i = 0; i < 3; i++) {
            if(ticTacToe[y][i].equals(currentMark)) {
                count++;
            }
        }
        if(count == 3) {
            isSuccess = true;
            return isSuccess;
        } else {
            count = 0;
        }


        // 세로 검증
        for (int i = 0; i < 3; i++) {
            if(ticTacToe[i][x].equals(currentMark)) {
                count++;
            }
        }
        if(count == 3) {
            isSuccess = true;
            return isSuccess;
        } else {
            count = 0;
        }
        
        // 대각(왼쪽위~오른쪽아래) 검증
        if(x != 1 && x == y || x == 1 && x == y) {
            for (int i = 0; i < 3; i++) {
                if(ticTacToe[i][i].equals(currentMark)) {
                    count++;
                }
            }
            if(count == 3) {
                isSuccess = true;
                return isSuccess;
            } else {
                count = 0;
            }
        }

        // 대각(왼쪽아래~오른쪽위) 검증
        if(x != 1 && Math.abs(x-y) == 2 || x == 1 && x == y) {
            for (int i = 0; i < 3; i++) {
                if(ticTacToe[i][2-i].equals(currentMark)) {
                    count++;
                }
            }
            if(count == 3) {
                isSuccess = true;
                return isSuccess;
            } else {
                count = 0;
            }
        }
        return isSuccess;
    }
}
