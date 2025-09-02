package inbox;

import java.util.Scanner;

public class Silver4_1388_바닥장식 {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String[] size = scan.nextLine().split(" "); // 6 9

        int row = Integer.parseInt(size[0]); // 6
        int col = Integer.parseInt(size[1]); // 9
        String[][] deco = new String[row][col]; // [6][9]


        for(int i = 0; i < row; i++) { // 6
            String[] input = scan.nextLine().split(""); // 9개의 입력

            for(int j = 0; j < col; j++) { // 9
                deco[i][j] = input[j];
            }
        }

        int count = 0;

        // 조합한 바닥은 빈 문자열로 바꿔서 계산 -> null이 아니면서 |이거나 -인 경우
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(deco[i][j].equals("-")) {
                    System.out.println("count 증가 -> deco[" + i + "][" + j + "]");
                    count++;
                    for(int k = 0; k < col -j; k++) {
                        if(deco[i][j+k].equals("-")) {
                            deco[i][j+k] = "";
                        } else if (deco[i][j+k].equals("|")) {
                            break;
                        }
                    }
                    //deco[j][i] = "";
                } else if (deco[i][j].equals("|")) {
                    System.out.println("count 증가 -> deco[" + i + "][" + j + "]");
                    count++;
                    for(int k = 0; k < row-i; k++) {
                        if(deco[i+k][j].equals("|")) {
                            deco[i+k][j] = "";
                        } else if (deco[i+k][j].equals("-")) {
                            break;
                        }
                    }
                    //deco[j][i] = "";
                }
            }
        }
        System.out.println(count);


    }
}











