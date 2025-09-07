package bruteforce;

import java.util.Scanner;

public class Silver5_1436_영화감독숌 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        int six = 665;
        int count = 0;

        while (count < input) {
            six++;
            if(String.valueOf(six).contains("666")) {
                count++;
            }
        }

        System.out.println(six);
    }
}
