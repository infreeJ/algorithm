package simulation;

import java.io.*;

public class Silver4_1331_나이트투어 {
    /**
     * 접근 방법
     * 1. 6 x 6의 배열을 만든다. 이 배열은 방문 여부를 나타내는 boolean[][] 이다.
     * 2. 입력을 받고 각 입력의 이동이 유효한지 검증
     * 3. 주어진 입력에 맞게 배열의 값을 true로 변경한다.
     * 4. 만일 방문한 칸이 이미 true라면 즉시 Invalid를 출력하고 종료한다.
     * 5. 입력이 끝난 후 두 가지를 검증하고 통과하면 Valid, 아니라면 Invalid를 출력한다.
     *      - 모든 배열의 값이 true인지
     *      - 마지막으로 방문한 위치가 처음 시작한 위치와 일치하는지
     */


    /**
     * 책임 분배
     * 1. 사용자의 입력을 받고 결과를 출력하는 main 메서드
     * 2. 나이트의 이동 위치가 유효한지 확인하는 메서드
     * 3. 방문 처리 메서드
     * 4. 모든 방이 true 인지 검증하는 메서드
     * 5. 포인터 변환 메서드
     */

    private static final boolean[][] chess = new boolean[6][6];

    /**
     * 입력을 받고 결과를 출력하는 메서드
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] input = new String[36];

        // 좌표 입력
        for (int i = 0; i < 36; i++) {
            input[i] = br.readLine();
        }

        // 입력받은 인풋 배열이 이동 가능한 좌표들인지 검증
        for (int i = 1; i < 36; i++) {
            if(!CheckMove(input[i-1], input[i])) {
                System.out.println("Invalid");
                return;
            }
        }

        for (int i = 0; i < 36; i++) {

            boolean visited = visitRoom(input[i]); // 방문 성공 여부 확인


            // 이미 방문했다면 Invalid를 출력하고 즉시 종료
            if(!visited) {
                System.out.println("Invalid");
                return;
            }
        }


        // 두 가지 조건 검증
        boolean isTrueSuccess = verificationTrue(); // 모두 true 인지 검증
        boolean isReturnSuccess = CheckMove(input[35], input[0]); // 첫 위치로 돌아왔는지 검증

        if(isTrueSuccess && isReturnSuccess) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }


    /**
     * 나이트의 이동 위치가 유효한지 확인하는 메서드
     */
    private static boolean CheckMove(String prevInput, String currentInput) {
        int prevX = convertPoint(prevInput.charAt(0));
        int prevY = Integer.parseInt(String.valueOf(prevInput.charAt(1))) -1;
        int currentX = convertPoint(currentInput.charAt(0));
        int currentY = Integer.parseInt(String.valueOf(currentInput.charAt(1))) -1;

        int distanceX = Math.abs(prevX - currentX);
        int distanceY = Math.abs(prevY - currentY);

        boolean isMoveSuccess = false;

        if(distanceX == 1) {
            if(distanceY == 2) {
                isMoveSuccess = true;
            }
        }

        if(distanceX == 2) {
            if(distanceY == 1) {
                isMoveSuccess = true;
            }
        }

        return isMoveSuccess;
    }


    /**
     * 방문 처리 메서드
     */
    private static boolean visitRoom(String input) {

        int x = convertPoint(input.charAt(0));
        int y = Integer.parseInt(String.valueOf(input.charAt(1))) -1;

        if(chess[y][x]) { // 이미 방문처리 되어있는 경우
            return false; // 방문 처리 실패
        } else {
            chess[y][x] = true;
            return true; // 방문 처리 성공
        }
    }

    /**
     * 모든 방이 true 인지 검증하는 메서드
     */
    private static boolean verificationTrue() {
        boolean isSuccess = true;
        
        // 모든 배열을 순환하며 true 인지 검증
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(!chess[i][j]) {
                    isSuccess = false; // 아니라면 false로 업데이트
                }
            }
        }
        return isSuccess;
    }


    /**
     * 포인터 변환 메서드
     */
    private static int convertPoint(char x) {
        return switch (x) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            case 'E' -> 4;
            case 'F' -> 5;
            default -> throw new RuntimeException("올바르지 않은 않은 입력");
        };
    }
}
