package inbox;

import java.io.*;
import java.util.*;

public class Silver3_1966_프린터큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        // 테스트케이스 수만큼 입력 받기
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            Queue<Integer[]> queue = new LinkedList<>();
            String[] queueInput = br.readLine().split(" ");

            // queue 구성
            for (int j = 0; j < N; j++) {
                // 0에는 인덱스, 1에는 중요도를 담아
                Integer[] tmp = {j, Integer.parseInt(queueInput[j])};
                queue.add(tmp); // 큐에 삽입
            }

            // 인쇄 순서를 카운트할 변수
            int count = 0;

            while(!queue.isEmpty()) {
                Integer[] current = queue.poll();
                int currentNum = current[0]; // 현재 인덱스
                int importance = current[1]; // 현재 중요도

                // 꺼낸 큐의 중요도보다 큐에 남아있는 서류 중 중요도가 더 높은 서류가 있다면 true
                if(queue.stream().anyMatch(data -> data[1] > importance)) {
                    queue.add(current); // 다시 큐의 맨 뒤에 넣는다.
                } else { // 아니라면
                    count++; // 인쇄한 것이므로 count 증가
                    if(currentNum == M) { // 인덱스가 찾으려던 서류와 일치한다면
                        bw.write(String.valueOf(count)); // 출력
                        bw.newLine();
                        break; // 찾으면 즉시 종료
                    }
                }

            }
        }
        bw.flush();
        bw.close();
    }
}
