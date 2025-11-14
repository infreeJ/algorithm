package implementation;

import java.util.Scanner;

public class Bronze3_10988_팰린드롬인지확인하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String input = scan.nextLine();

        sb.append(input);

        new Scanner(System.in);
        if(input.equals(sb.reverse().toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
