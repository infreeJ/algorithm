package simulation;

import java.io.*;

public class Silver5_9037_TheCandyWar {
    /**
     * 접근 방법
     * 1. 배열을 순환하며 홀수가 있으면 +1
     * 2. 모든 값이 같은지 비교하교 같다면 count 값을 return한다.
     * 3. 같지 않다면 tmp 변수를 사용해서 현재 값의 절반을 다음 값으로 넘겨준다.
     */

    static int[] children; // 아이들이 가진 사탕 수의 배열

    /**
     * 입력을 받고 결과를 출력하는 메서드
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스

            // 배열 초기화
            children = new int[N];
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                children[j] = Integer.parseInt(input[j]);
            }

            // count 값 쓰기
            bw.write(String.valueOf(distributeCandy()));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    /**
     * 사탕을 나누는 메서드
     * @return 순환 횟수
     */
    private static int distributeCandy() {
        int count = 0; // 순환 횟수

        checkOddCandy();
        if(checkCandyNumber()) { // 사탕 수가 같다면 return
            return count;
        }

        while (true) {
            checkOddCandy();
            if(checkCandyNumber()) { // 사탕 수가 같다면 return
                return count;
            }

            int pass = children[0] / 2; // 다음 아이에게 넘길 사탕
            children[0] /= 2;

            for (int i = 1; i < children.length; i++) {
                children[i] /= 2;
                int tmp = children[i];
                children[i] += pass;
                pass = tmp;
            }
            children[0] += pass; // 마지막 아이가 첫 아이에게 사탕 전달

            count++;
        }
    }


    /**
     * 아이들이 가진 사탕이 홀수인지 확인하고 홀수라면 +1 해주는 메서드
     */
    private static void checkOddCandy() {
        for (int i = 0; i < children.length; i++) {
            if(children[i] % 2 == 1) {
                children[i]++;
            }
        }
    }


    /**
     * 아이들이 가진 사탕이 모두 같은 수인지 확인하는 메서드
     */
    private static boolean checkCandyNumber() {
        boolean confirm = true;
        for (int i = 1; i < children.length; i++) {
            if(children[0] != children[i]) {
                confirm = false;
            }
        }

        return confirm;
    }
}
