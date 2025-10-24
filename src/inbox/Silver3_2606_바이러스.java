package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver3_2606_바이러스 {

    static boolean[] isVirus; // 각 컴퓨터 별 바이러스 유무

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computers = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int t = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수

        isVirus = new boolean[computers];

        isVirus[0] = true; // 바이러스는 1번 컴퓨터에서 시작

        int[][] pairs = new int[t][2];
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            pairs[i][0] = Integer.parseInt(input[0]);
            pairs[i][1] = Integer.parseInt(input[1]);
        }

        // 늦게 입력되어도 정상적으로 바이러스에 걸릴 수 있게 정렬
        Arrays.sort(pairs, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        for (int i = 0; i < t; i++) {
            virusCheck(pairs[i][0], pairs[i][1]);
        }

        int count = -1; // 1번 컴퓨터는 제외
        for (int i = 0; i < isVirus.length; i++) {
            if(isVirus[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    // 연결된 한 쌍의 컴퓨터를 매개변수로 받아 바이러스를 전염시키는 메서드
    public static void virusCheck(int current, int next) {
        if(isVirus[current-1]) {
            isVirus[next-1] = true;
        }
    }

}

