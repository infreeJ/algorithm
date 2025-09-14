package greedy;

import java.util.Scanner;

public class Bronze2_2864_5와6의차이 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String[] input = scan.nextLine().split(" ");


        int min = Integer.parseInt(input[0].replace("6", "5")) + Integer.parseInt(input[1].replace("6", "5"));
        int max = Integer.parseInt(input[0].replace("5", "6")) + Integer.parseInt(input[1].replace("5", "6"));

        System.out.println(min + " " + max);
    }
}
