package bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bronze2_3040_백설공주와일곱난쟁이 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] hat = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            hat[i] = scan.nextInt();
            sum = sum + hat[i];
        }

        int tmp = sum;
        int indexI = 0;
        int indexJ = 0;

        for (int i = 0; i < 9; i++) {
            tmp = tmp - hat[i];

            for (int j = i + 1; j < 9; j++) {
                tmp = tmp - hat[j];

                if(tmp == 100) {
                    indexI = i;
                    indexJ = j;
                    break;
                } else {
                    tmp = tmp + hat[j];
                }
            }

            tmp = sum;
        }

        List<Integer> realDwarfs = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            if (i != indexI && i != indexJ) {
                realDwarfs.add(hat[i]);
            }
        }

        for(int i=0; i<7; i++) {
            System.out.println(realDwarfs.get(i));
        }

    }
}