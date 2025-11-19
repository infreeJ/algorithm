package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3_10451_순열사이클 {

    /*
    접근 방법
    - visited[]과 count를 정의한다.
    - 반복문을 돌면서 해당 인덱스에 방문한 적이 없다면 count를 증가시키고 bfs를 호출한다.
    - bfs 안에서는 현재 노드를 방문 처리 하고, 다음 위치를 찾아서 방문한 적이 없다면 재귀 호출한다.
    - 즉, 더이상 방문할 노드가 없을 때까지 반복하며 방문처리한다.
     */

    /**
     * DFS 함수
     * @param current 현재 위치
     * @param permutation 순열[]
     * @param visited 방문 여부[]
     */
    static void dfs(int current, int[] permutation, boolean[] visited) {
        visited[current] = true; // 방문 처리
        int next = permutation[current]; // 다음 위치
        if(!visited[next]) { // 다음 위치에 방문한 적 없다면 재귀 호출
            dfs(next, permutation, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int size = Integer.parseInt(br.readLine()); // 순열의 사이즈
            String[] input = br.readLine().split(" "); // 순열 입력값
            int[] permutation = new int[size+1]; // 순열(1부터 사용하기 위해 size+1)
            boolean[] visited = new boolean[size + 1]; // 방문 여부(1부터 사용하기 위해 size+1)
            int count = 0; // 사이클의 개수

            // 순열에 값 대입
            for (int j = 1; j <= size; j++) {
                permutation[j] = Integer.parseInt(input[j-1]);
            }


            for (int j = 1; j <= size; j++) {
                if(!visited[j]) { // 방문하지 않았다면
                    count++;
                    dfs(j, permutation, visited);
                }
            }

            System.out.println(count);
        }
    }
}
