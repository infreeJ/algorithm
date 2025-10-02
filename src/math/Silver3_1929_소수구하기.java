package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver3_1929_소수구하기 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {

            String[] input = br.readLine().split(" ");
            int min = Integer.parseInt(input[0]);
            int max = Integer.parseInt(input[1]);


            for (int i = min; i <= max; i++) {
                if (i == 1) {
                    continue;
                }

                boolean isSuccess = true;

                for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isSuccess = false;
                        break;
                    }
                }

                if (isSuccess) {
                    bw.write(String.valueOf(i));
                    bw.newLine();
                }

            }

            bw.flush();
            bw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}















