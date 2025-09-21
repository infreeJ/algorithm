package greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Silver4_11047_동전0 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        int coins = Integer.parseInt(input[0]);
        int money = Integer.parseInt(input[1]);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < coins; i++) {
            list.add(scan.nextInt());
            scan.nextLine();
        }

        int count = 0;
        for (int i = list.size()-1; i >= 0; i--) {

            count += money / list.get(i);
            money %= list.get(i);
            if(money == 0) {
                break;
            }
        }

        System.out.println(count);

    }
}
