package bruteforce;

import java.util.Scanner;

public class Silver5_14912_숫자빈도수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int num = Integer.parseInt(input[0]);
        String target = input[1];
        int count = 0;

        for (int i = 1; i <= num; i++) {
            String[] tmp = String.valueOf(i).split("");
            for (int j = 0; j < tmp.length; j++) {
                if(tmp[j].equals(target)) {
                    count++;
                }
            }

        }

        System.out.println(count);
    }
}
