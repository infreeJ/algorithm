package inbox;

import java.util.Scanner;

public class Silver4_2839_설탕배달 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        scan.nextLine();

        int five = 0;
        int three = 0;

        five += num / 5;
        num %= 5;
        three += num / 3;
        num %= 3;

        if(num == 0) {
            System.out.println(five + three);
            return;
        }

        while(five > 0) {
            five--;
            num += 5;
            three += num/3;
            num %= 3;
            if(num == 0) {
                System.out.println(five + three);
                return;
            }
        }

        System.out.println("-1");
    }
}
