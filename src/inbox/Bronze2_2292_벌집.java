package inbox;

import java.util.Scanner;

public class Bronze2_2292_벌집 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();

        int count = 1;
        int room = 1;

        int tmp = 6;

        for(int i=1; i<=t; i++) {
            if(i > room) {
                count++;
                room = room + tmp;
                tmp = tmp + 6;
            }
        }
        System.out.println(count);
    }
}
