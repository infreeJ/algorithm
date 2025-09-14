package greedy;

import java.util.Scanner;

public class Bronze2_14720_우유축제 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        scan.nextLine();

        int count = 0;

        String[] tmp = scan.nextLine().split(" ");
        int[] num = new int[t];

        for (int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(tmp[i]);
        }

        int index = 5;
        for (int i = 0; i < t; i++) {
            if (num[i] == 0) {
                index = i;
                break;
            }
        }

        int milk = num[index];
        if (milk == 0) {
            count++;
        }
        boolean search = false;
        for (int i = index; i < t - 1; i++) {
            if (search) {
                milk = num[i];
            }
            if (milk < 2 && milk + 1 == num[i + 1]) {
                count++;
                search = true;
            } else if (milk == 2 && num[i + 1] == 0) {
                count++;
                search = true;
            } else {
                search = false;
            }
        }

        System.out.println(count);
    }
}
