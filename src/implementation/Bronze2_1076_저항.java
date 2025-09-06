package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze2_1076_저항 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {
            String[] input = new String[3];
            for (int i = 0; i < 3; i++) {
                input[i] = br.readLine();
            }

            String[] value = new String[2];
            for (int i = 0; i < 2; i++) {
                switch (input[i]) {
                    case "black":
                        value[i] = "0";
                        break;
                    case "brown":
                        value[i] = "1";
                        break;
                    case "red":
                        value[i] = "2";
                        break;
                    case "orange":
                        value[i] = "3";
                        break;
                    case "yellow":
                        value[i] = "4";
                        break;
                    case "green":
                        value[i] = "5";
                        break;
                    case "blue":
                        value[i] = "6";
                        break;
                    case "violet":
                        value[i] = "7";
                        break;
                    case "grey":
                        value[i] = "8";
                        break;
                    case "white":
                        value[i] = "9";
                        break;
                }
            }

            long x = 0;

            switch (input[2]) {
                case "black":
                    x = 1;
                    break;
                case "brown":
                    x = 10;
                    break;
                case "red":
                    x = 100;
                    break;
                case "orange":
                    x = 1000;
                    break;
                case "yellow":
                    x = 10000;
                    break;
                case "green":
                    x = 100000;
                    break;
                case "blue":
                    x = 1000000;
                    break;
                case "violet":
                    x = 10000000;
                    break;
                case "grey":
                    x = 100000000;
                    break;
                case "white":
                    x = 1000000000;
                    break;
            }


            sb.append(value[0]).append(value[1]);
            long plus = Integer.parseInt(sb.toString());

            System.out.println(plus * x);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
