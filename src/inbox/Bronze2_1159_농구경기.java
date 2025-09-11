package inbox;

import java.util.Scanner;

public class Bronze2_1159_농구경기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = scan.nextInt();
        scan.nextLine();

        int[] asc = new int[26];

        for (int i = 0; i < t; i++) {
            char input = scan.nextLine().charAt(0);
            asc[input - 97] += 1;
        }

        for (int i = 0; i < asc.length; i++) {
            if(asc[i] >= 5) {
                int a = i + 97;
                sb.append((char)a);
            }
        }

        if(sb.toString().isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }
    }
}
