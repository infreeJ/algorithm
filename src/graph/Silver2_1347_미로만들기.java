package graph;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Silver2_1347_미로만들기 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scan.nextInt();
        scan.nextLine();

        String[] input = scan.nextLine().split("");

        int[] x = {0, -1, 0, 1};
        int[] y = {-1, 0, 1, 0};
        int direction = 2;

        String[][] arr = new String[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                arr[i][j] = "#";
            }
        }

        int currentX = 50;
        int currentY = 50;
        arr[currentX][currentY] = ".";

        for (int i = 0; i < t; i++) {

            switch(input[i]) {
                case "L" :
                    direction = (direction+1) % 4;
                    break;
                case "R" :
                    direction = (direction-1);
                    if(direction == -1) {
                        direction = 3;
                    }
                    break;
                case "F" :
                    currentX = currentX + x[direction];
                    currentY = currentY + y[direction];
                    arr[currentY][currentX] = ".";
            }

        }

        // 테스트 출력용
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 100; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }


        int minX = 100;
        int minY = 100;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(arr[i][j].equals(".")) {
                    if(minX > j) {
                        minX = j;
                    }
                    if(minY > i) {
                        minY = i;
                    }
                    if(maxX < j) {
                        maxX = j;
                    }
                    if(maxY < i) {
                        maxY = i;
                    }

                }
            }
        }

        for (int i = minY; i < maxY+1; i++) {
            for (int j = minX; j < maxX+1; j++) {
                bw.append(arr[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
