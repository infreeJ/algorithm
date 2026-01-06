package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_1260_DFS와BFS {

    /*
    책임 분리
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 깊이 우선 탐색을 하는 dfs 메서드
    3. 너비 우선 탐색을 하는 bfs 메서드
    4. 방문 및 세부 데이터 정렬 처리하는 visitProcess 메서드
    5. Graph를 서로 연결하는 graphInit 메서드
     */

    static class Graph {
        int num;
        List<Graph> neighbors;
        boolean isVisit;

        Graph(int num) {
            this.num = num;
            neighbors = new ArrayList<>();
            isVisit = false;
        }

        void addNeighbor(Graph graph) {
            this.neighbors.add(graph);
            graph.neighbors.add(this);
        }
    }


    static Graph[] dfsGraphs;
    static Graph[] bfsGraphs;
    static Queue<Graph> bfsQueue = new LinkedList<>();
    static List<Integer> answer = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);
        int V = Integer.parseInt(input1[2]);

        dfsGraphs = new Graph[N+1];
        bfsGraphs = new Graph[N+1];

        for(int i = 1; i <= N; i++) {
            dfsGraphs[i] = new Graph(i);
            bfsGraphs[i] = new Graph(i);
        }

        int[][] arr = new int[M][2];

        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input2[0]);
            arr[i][1] = Integer.parseInt(input2[1]);
        }

        graphInit(arr);

        dfs(dfsGraphs[V]);

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
        sb.setLength(0);

        answer = new ArrayList<>();
        bfs(bfsGraphs[V]);

        for (int i : answer) {
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());

    }


    static void dfs(Graph graph) {
        if(!visitProcess(graph)) {
            return;
        }

        for(Graph neighbor : graph.neighbors) {
            dfs(neighbor);
        }

    }

    static void bfs(Graph graph) {
        bfsQueue.offer(graph);

        while(!bfsQueue.isEmpty()) {
            Graph current = bfsQueue.poll();

            if(!visitProcess(current)) {
                continue;
            }

            for(Graph next : current.neighbors) {
                if(next.isVisit) {
                    continue;
                }
                bfsQueue.offer(next);
            }
        }
    }

    static boolean visitProcess(Graph graph) {
        if(graph.isVisit) {
            return false;
        }

        graph.isVisit = true;
        answer.add(graph.num);

        graph.neighbors.sort((a, b) -> {
            return a.num - b.num;
        });

        return true;
    }


    static void graphInit(int[][] arr) {
        for (int[] intArr : arr) {

            if (!dfsGraphs[intArr[0]].neighbors.contains(dfsGraphs[intArr[1]])) {
                dfsGraphs[intArr[0]].addNeighbor(dfsGraphs[intArr[1]]);
            }
            if (!bfsGraphs[intArr[0]].neighbors.contains(bfsGraphs[intArr[1]])) {
                bfsGraphs[intArr[0]].addNeighbor(bfsGraphs[intArr[1]]);
            }
        }
    }
}