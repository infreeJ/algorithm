package implementation;

import java.util.Scanner;

public class Bronze2_1453_피시방알바 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int customers = scan.nextInt();
        scan.nextLine();
        boolean[] in = new boolean[100];

        String[] wantStr = scan.nextLine().split(" ");
        int[] wantInt = new int[customers];

        for(int i=0; i<customers; i++) {
            wantInt[i] = Integer.parseInt(wantStr[i]);
        }

        int count = 0;
        for(int i=0; i<customers; i++) {
            if(in[wantInt[i]-1]) {
                count++;
            } else {
                in[wantInt[i]-1] = true;
            }
        }

        System.out.println(count);
    }
}
