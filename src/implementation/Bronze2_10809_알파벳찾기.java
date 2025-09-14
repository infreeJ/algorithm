package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Bronze2_10809_알파벳찾기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();

        char[] alphabet = new char[word.length()];
        int[] alphabetInt = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            alphabet[i] = word.charAt(i);
            alphabetInt[i] = alphabet[i] - 97;
        }

        int[] asc = new int[26];
        Arrays.fill(asc, -1);

        for (int i = alphabetInt.length-1; i >= 0; i--) {
            asc[alphabetInt[i]] = word.indexOf(alphabet[i]);
        }

        for (int i = 0; i < asc.length; i++) {
            System.out.print(asc[i] + " ");
        }
    }
}
