package implementation;

import java.io.*;

public class Bronze1_10798_세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input1 = br.readLine().split("");
        String[] input2 = br.readLine().split("");
        String[] input3 = br.readLine().split("");
        String[] input4 = br.readLine().split("");
        String[] input5 = br.readLine().split("");

        for (int i = 0; i < 15; i++) {
            if(i < input1.length) {
                sb.append(input1[i]);
            }
            if(i < input2.length) {
                sb.append(input2[i]);
            }
            if(i < input3.length) {
                sb.append(input3[i]);
            }
            if(i < input4.length) {
                sb.append(input4[i]);
            }
            if(i < input5.length) {
                sb.append(input5[i]);
            }
        }

        System.out.println(sb.toString());
    }
}
