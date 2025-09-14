package implementation;

import java.util.Scanner;

public class Bronze1_1259_팰린드롬수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String input = scan.nextLine();

        if(!input.equals("0")) {
            while(!input.equals("0")) {
                sb.append(input);
                sb.reverse();

                if(input.contentEquals(sb.toString())) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
                sb.delete(0, sb.length());
                input = scan.nextLine();
            }
        }
    }
}
