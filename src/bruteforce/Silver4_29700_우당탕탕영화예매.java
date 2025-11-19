package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver4_29700_우당탕탕영화예매 {
    
    /*
    접근방법
    - 2차원 boolean 배열을 만들고 좌석 상황을 반영한다.
    - 각 줄을 순환하며 좌석이 비어있을 경우 tmp를 증가시킨다
    - tmp 값이 인원 수와 같거나 많을 경우 count를 증가시킨다.
    - 줄의 마지막 좌석을 만나거나 이미 예매된 좌석을 만나면 tmp 값을 초기화시킨다.
     */

    static int tmp; // 앉을 수 있는 좌석을 세는 변수
    static int count; // 이어서 앉을 수 있는 경우의 수
    static int K; // 동아리원 수

    /**
     * 좌석의 예약 가능 여부를 체크하는 메서드
     * @param seat 좌석이 이미 예약 됐는지
     * @param last 이번 줄의 마지막 좌석인지
     */
    static void seatCheck(boolean seat, boolean last) {
        if(!seat) {
            ++tmp;
            if(tmp >= K) {
                count++;
            }
        } else {
            tmp = 0;
        }
        if(last) {
            tmp = 0;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 행
        int M = Integer.parseInt(input[1]); // 열
        K = Integer.parseInt(input[2]); // 동아리원

        boolean[][] cinema = new boolean[M][N]; // 영화관

        for (int i = 0; i < N; i++) {
            String[] seats = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                cinema[j][i] = seats[j].equals("1");
            }
        }


        for (int i = 0; i < N; i++) {
            boolean last = false;
            for (int j = 0; j < M; j++) {
                if(j == M-1) {
                    last = true; // 이번 줄의 마지막 좌석이라면 true
                }
                seatCheck(cinema[j][i], last);
            }
        }

        System.out.println(count);
    }
}
