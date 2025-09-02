package inbox;

import java.util.Scanner;

public class Silver4_1388_바닥장식 {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" "); // 2 3

        int vertical = Integer.parseInt(input[0]); // 6
        int horizontal = Integer.parseInt(input[1]); // 9
        String[][] deco = new String[horizontal][vertical]; // [3][2]


        for(int i = 0; i < vertical; i++) { // 2
            String[] row = scan.nextLine().split(""); // 3개의 입력

            for(int j = 0; j < horizontal; j++) { // 3
                deco[j][i] = row[j];
            }
        }
        /*

        -|--
        -|--
        ||-|
        |--|

         */

        int count = 0;
        // 조합한 바닥은 빈 문자열로 바꿔서 계산 -> null이 아니면서 |이거나 -인 경우
        for(int i = 0; i < vertical; i++) {
            for(int j = 0; j <horizontal; j++) {

                if(deco[j][i].equals("-") && !deco[j][i].isEmpty()) {
                    System.out.println("count 증가 -> deco[" + j + "][" + i + "]");
                    count++;
                    for(int k = 1; k < horizontal-j; k++) {
                        if(deco[j+k][i].equals("-")) {
                            deco[j+k][i] = "";
                        } else if (deco[j+k][i].equals("|")) {
                            break;
                        }
                    }
                    deco[j][i] = "";
                } else if (deco[j][i].equals("|") && !deco[j][i].isEmpty()) {
                    System.out.println("count 증가 -> deco[" + j + "][" + i + "]");
                    count++;
                    for(int k = 1; k < vertical-i; k++) {
                        if(deco[j][i+k].equals("|")) {
                            deco[j][i+k] = "";
                        } else if (deco[j][i+k].equals("-")) {
                            break;
                        }
                    }
                    deco[j][i] = "";
                }
            }
        }
        System.out.println(count);


    }
}











