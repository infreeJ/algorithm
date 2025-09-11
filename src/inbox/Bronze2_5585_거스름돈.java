package inbox;

import java.util.Scanner;

public class Bronze2_5585_거스름돈 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pay = 1000 - scan.nextInt();
        scan.nextLine();

        int count = 0;

        int[] money = {500, 100, 50, 10, 5};

        for (int i = 0; i < money.length; i++) {
            count += pay / money[i];
            pay = pay % money[i];
        }

        count += pay;
        System.out.println(count);

    }
}
