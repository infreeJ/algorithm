package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Silver1_2178_미로탐색 {

    static int[] x = {0, 0, -1, 1};
    static int[] y = {-1, 1, 0, 0};

    static int n, m;
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] size = scan.nextLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(maze[n-1][m-1]);
    }


    public static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + x[i];
                int nextY = currentY + y[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if(visited[nextX][nextY] || maze[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;

                maze[nextX][nextY] = maze[currentX][currentY] + 1;
            }
        }
    }
}
