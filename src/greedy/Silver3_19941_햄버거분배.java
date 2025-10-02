package greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Silver3_19941_햄버거분배 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");

        int table = Integer.parseInt(input[0]);
        int distance = Integer.parseInt(input[1]);

        String[] input2 = scan.nextLine().split("");


        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < input2.length; i++) {
            list.add(i, input2[i]);
        }

        int count = 0;

        for (int i = 0; i < table; i++) {

            if(list.get(i).equals("P")) {
                for (int j = i-distance; j <= i+distance; j++) {

                    if(j < 0 || j >= list.size()) {
                        continue;
                    }

                    if(list.get(j).equals("H")) {
                        count++;
                        list.set(j, "N");
                        break;
                    }

                }
            }
        }

        System.out.println(count);
    }
}
