package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3_1018_체스판다시칠하기 {
    public static boolean[][] chess;
    public static boolean initCol = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력
        String[] sizeInput = br.readLine().split(" ");
        int N = Integer.parseInt(sizeInput[0]);
        int M = Integer.parseInt(sizeInput[1]);

        // 체스판 구성
        chess = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (input[j].equals("W")) {
                    chess[i][j] = true;
                } else {
                    chess[i][j] = false;
                }
            }
        }

        // 최소값 정의
        int min = 64;

        // 첫 칸이 블랙인 경우와 화이트인 2가지 경우의 수
        for (int i = 0; i < 2; i++) {
            if(i == 1) {
                initCol = false;
            }
            for (int j = 0; j < N -7; j++) {
                for (int k = 0; k < M -7; k++) {
                    int count = chessSearch(j, k);
                    if(min > count) {
                        min = count;
                    }
                }
            }
        }
        System.out.println(min);
    }

    public static int chessSearch(int startY, int startX) {
        int count = 0;

        for (int i = startY; i < startY+8; i++) {
            initCol = (!initCol); // 한 줄마다 col을 반대되는 색깔로 시작해야 한다.
            boolean col = initCol; // col은 올바른 체스판 색깔
            for (int j = startX; j < startX+8; j++) {
                if(chess[i][j] != col) { // 색이 올바르지 않으면 count 증가
                    count++;
                }
                col = !col;
            }
        }

        return count;
    }
}
