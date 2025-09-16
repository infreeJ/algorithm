package inbox;

import java.util.Scanner;

public class Silver4_1049_기타줄 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int guitar = Integer.parseInt(input[0]);
        int brand = Integer.parseInt(input[1]);

        int setPrice = 1000;
        int onePrice = 1000;

        for (int i = 0; i < brand; i++) {
            String[] tmp = scan.nextLine().split(" ");
            if(setPrice > Integer.parseInt(tmp[0])) {
                setPrice = Integer.parseInt(tmp[0]);
            }
            if(onePrice > Integer.parseInt(tmp[1])) {
                onePrice = Integer.parseInt(tmp[1]);
            }
        }

        int money = 0;

        if(onePrice * 6 < setPrice) {
            money = guitar * onePrice;
        } else {
            money = guitar / 6 * setPrice;
            guitar %= 6;
            if(guitar * onePrice < setPrice) {
                money += guitar * onePrice;
            } else {
                money += setPrice;
            }
        }

        System.out.println(money);
    }
}
