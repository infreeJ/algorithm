package data_structure;

import java.io.*;

public class Silver4_9012_괄호 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int[] arr = new int[2];
            String[] input = br.readLine().split("");
            boolean isSuccess = true;

            for (int j = 0; j < input.length; j++) {

                boolean shouldBreak = false;

                switch (input[j]) {
                    case "(" :
                        if(j == input.length-1 && arr[1] >= 1) {
                            isSuccess = false;
                            shouldBreak = true;
                        }
                        arr[0]++;
                        break;
                    case  ")" :
                        if(j == 0 || arr[0] <= arr[1]) {
                            isSuccess = false;
                            shouldBreak = true;
                        }
                        arr[1]++;
                        break;
                }
                if(shouldBreak) {
                    break;
                }
            }

            if(arr[0] == arr[1] && isSuccess) {
                bw.write("YES");
                bw.newLine();
            } else {
                bw.write("NO");
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
