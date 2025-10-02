package implementation;

import java.util.Scanner;

public class Bronze2_2908_상수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String[] input = scan.nextLine().split(" ");

        sb.append(input[0]);
        sb.reverse();
        int a = Integer.parseInt(sb.toString());
        sb.setLength(0);

        sb.append(input[1]);
        sb.reverse();
        int b = Integer.parseInt(sb.toString());


        if(a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
