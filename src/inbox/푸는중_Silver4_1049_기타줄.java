package inbox;

import java.util.Scanner;

public class 푸는중_Silver4_1049_기타줄 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int guitar = Integer.parseInt(input[0]);
        int brand = Integer.parseInt(input[1]);

        int setMin = 0;
        int oneMin = 0;

        for (int i = 0; i < brand; i++) {
            String[] tmp = scan.nextLine().split(" ");
            if(setMin > Integer.parseInt(tmp[0])) {
                setMin = Integer.parseInt(tmp[0]);
            }
            if(oneMin > Integer.parseInt(tmp[1])) {
                oneMin = Integer.parseInt(tmp[1]);
            }
        }

        int money = 0;
        int tmp = 0;

        if(oneMin * 6 < setMin) {
            money = guitar * oneMin;
        } else {
            money = guitar / 6 * setMin;
            guitar %= 6;
            money += guitar * oneMin;
        }

        System.out.println(money);
    }
}
