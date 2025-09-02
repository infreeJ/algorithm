package implementation;

import java.util.Scanner;

public class Bronze3_2754_학점계산 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        double output = 0;

        switch (input.charAt(0)) {
            case 'A':
                output = 4.0;
                break;
            case 'B':
                output = 3.0;
                break;
            case 'C':
                output = 2.0;
                break;
            case 'D':
                output = 1.0;
                break;
            case 'F':
                output = 0.0;
                break;
        }
        if(input.charAt(0) == 'A' || input.charAt(0) == 'B' || input.charAt(0) == 'C' || input.charAt(0) == 'D') {
            switch (input.charAt(1)) {
                case '+':
                    output += 0.3;
                    break;
                case '-':
                    output -= 0.3;
                    break;
            }
        }
        System.out.print(output);

    }
}