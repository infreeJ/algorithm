package greedy;

import java.util.Scanner;

public class Silver5_14916_거스름돈 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int money = scan.nextInt();
        scan.nextLine();

        int five = 0;
        int two = 0;

        five = money / 5;
        money %= 5;
        if(money % 2 == 0) {
            two = money / 2;
            money -= 2 * two;
        } else {
            if(five != 0) {
                five--;
                money += 5;
            }
            two = money / 2;
            money -= 2 * two;
        }

        boolean success = false;

        if(money == 0) {
            success = true;
        }

        if(success) {
            System.out.println(five + two);
        } else {
            System.out.println(-1);
        }
    }
}
