package implementation;

import java.util.Scanner;

public class Bronze2_20001_고무오리디버깅 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String startStr = scan.nextLine();
        if(startStr.equals("고무오리 디버깅 시작")) {
            int question = 0;
            String input;

            while (true) {
                input = scan.nextLine();
                if(input.equals("문제")) {
                    question++;
                } else if (input.equals("고무오리")) {
                    if(question > 0) {
                        question--;
                    } else if(question == 0) {
                        question = question + 2;
                    }
                } else if (input.equals("고무오리 디버깅 끝")) {
                    break;
                }
            }

            if (question == 0) {
                System.out.println("고무오리야 사랑해");
            } else {
                System.out.println("힝구");
            }

        }
    }
}