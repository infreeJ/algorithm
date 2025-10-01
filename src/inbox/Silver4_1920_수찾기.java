package inbox;

import java.util.HashSet;
import java.util.Scanner;

public class Silver4_1920_수찾기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        String[] input1 = scan.nextLine().split(" ");

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(input1[i]);
        }


        int m = scan.nextInt();
        scan.nextLine();

        String[] input2 = scan.nextLine().split(" ");

        for (int i = 0; i < m; i++) {
            if(set.contains(input2[i])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
