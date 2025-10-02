package math;

import java.util.ArrayList;
import java.util.Scanner;

public class Silver4_2960_에라토스테네스의체 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int remove = Integer.parseInt(input[1]);

        ArrayList<Integer> list = new ArrayList<>();

        int count = 0;
        for (int i = 2; i <= num; i++) {

            int tmp = i;

            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    tmp = 0;
                    break;
                }
            }


            if (tmp != 0) {
                for (int j = tmp; j <= num; j += tmp) {
                    if(!list.contains(j)) {
                        list.add(j);
                        count++;
                        if(count == remove) {
                            System.out.println(j);
                        }
                    }
                }
            }

        }
    }
}
