package inbox;

import java.util.Scanner;

public class Bronze2_18238_ZOAC2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        int[] alphabet = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            alphabet[i] = word.charAt(i) - 65;
        }


        int arrow = 0;
        int count = 0;
        int tmp = 0;

        for (int i = 0; i < alphabet.length; i++) {
            tmp = arrow - alphabet[i];
            if(Math.abs(tmp) >= 13) {
                tmp = Math.abs(Math.abs(tmp) - 26);
            } else {
                tmp = Math.abs(tmp);
            }

            count += tmp;
            arrow = alphabet[i];
        }

        System.out.println(count);

    }
}
