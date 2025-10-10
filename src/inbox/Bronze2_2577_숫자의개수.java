package inbox;

import java.util.Scanner;

public class Bronze2_2577_숫자의개수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = 1;
        for (int i = 0; i < 3; i++) {
            num *= scan.nextInt();
            scan.nextLine();
        }

        int[] arr = new int[10];

        String numStr = String.valueOf(num);

        for (int i = 0; i < numStr.length(); i++) {
            arr[Integer.parseInt(String.valueOf(numStr.charAt(i)))]++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
