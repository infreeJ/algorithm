package math;

import java.util.Scanner;

public class Bronze1_2869_달팽이는올라가고싶다 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int up = Integer.parseInt(input[0]);
        int down = Integer.parseInt(input[1]);
        int height = Integer.parseInt(input[2]);

        double day = up - down;
        double yesterday = height - up;

        int result = (int)Math.ceil(yesterday / day);

        System.out.println(result + 1);

    }
}
