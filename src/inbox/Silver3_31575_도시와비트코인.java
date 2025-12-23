package inbox;

import java.io.*;

public class Silver3_31575_도시와비트코인 {

    /*
    접근 방법
    1. 2차원 배열을 정의하여 0과 1을 입력받는다.
    2. 재귀함수를 호출하며 각각 오른쪽, 아래로 인덱스가 증가하도록 한다.
    3. 값이 0 이거나, 이미 방문한 좌표는 제외하며 이동한다.
    4. 받은 인덱스가 도시의 끝이라면 Yes, 도착하지 못하면 No를 출력한다.
     */

    /*
    책임 분배
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 인덱스를 증가시키며 이동하는 재귀함수인 move 메서드
     */

    static int[][] city;
    static boolean[][] visit;
    static boolean isSuccess = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] t = br.readLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int M = Integer.parseInt(t[1]);

        city = new int[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 0, 0으로 호출
        move(0, 0);

        // 결과 출력
        if(isSuccess) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }

        bw.flush();
        bw.close();
    }

    static void move(int y, int x) {

        visit[y][x] = true;

        // 값이 0일 경우 예외
        if(city[y][x] == 0) {
            return;
        }

        // 도착점인 경우 성공 처리
        if(y == city.length -1 && x == city[0].length -1) {
            isSuccess = true;
        }


        // 인덱스를 초과하지 않고, 방문하지 않은 경우에만 재귀 호출
        if(y+1 < city.length && !visit[y+1][x]) {
            move(y+1, x);
        }
        if(x+1 < city[0].length && !visit[y][x+1]) {
            move(y, x+1);
        }
    }
}
