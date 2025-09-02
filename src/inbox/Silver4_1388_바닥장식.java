package inbox;

import java.util.Scanner;

public class Silver4_1388_바닥장식 {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String[] size = scan.nextLine().split(" "); // 6 9

        int row = Integer.parseInt(size[0]); // 6
        int col = Integer.parseInt(size[1]); // 9
        String[][] deco = new String[row][col]; // [6][9]
        boolean[][] check = new boolean[row][col];


        for(int i = 0; i < row; i++) { // 6
            String[] input = scan.nextLine().split(""); // 9개의 입력

            for(int j = 0; j < col; j++) { // 9
                deco[i][j] = input[j];
                check[i][j] = false;
            }
        }

        int count = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {


                if(deco[i][j].equals("-") && !check[i][j]) {
                    count++;
                    for(int k = j; k < col; k++) {
                        if(deco[i][k].equals("-")) {
                            check[i][k] = true;
                        } else if (deco[i][k].equals("|")) {
                            break;
                        }
                    }
                } else if (deco[i][j].equals("|") && !check[i][j]) {
                    count++;
                    for(int k = i; k < row; k++) {
                        if(deco[k][j].equals("|")) {
                            check[k][j] = true;
                        } else if (deco[k][j].equals("-")) {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);


    }
}











