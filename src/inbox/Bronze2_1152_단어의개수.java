package inbox;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bronze2_1152_단어의개수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim();

        StringTokenizer st = new StringTokenizer(input, " ");

        System.out.println(st.countTokens());
    }
}
