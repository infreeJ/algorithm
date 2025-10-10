package inbox;

import java.util.Scanner;

public class Silver4_2839_설탕배달 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        scan.nextLine();

        int count = 0;

        count += num / 5;
        num %= 5;

        count += num / 3;
        num %= 3;

        if (num == 0) {
        } else {

            while (true) {
                count--;
                num += 5;
                count += num / 3;
                num %= 3;
            }
        }
    }
}
