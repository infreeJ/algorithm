package greedy;

import java.util.Scanner;

public class Bronze1_14659_한조서열정리하고옴ㅋㅋ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        scan.nextLine();

        int[] mountains = new int[t];
        for (int i = 0; i < t; i++) {
            mountains[i] = scan.nextInt();
        }


        int kill = 0;
        int tmp = 0;

        for (int i = 0; i < mountains.length-1; i++) {
            for (int j = i+1; j < mountains.length; j++) {
                if(mountains[i] > mountains[j]) {
                    tmp++;
                    if(kill < tmp) {
                        kill = tmp;
                    }
                } else {
                    break;
                }
            }
            tmp = 0;
        }

        System.out.println(kill);
    }
}
