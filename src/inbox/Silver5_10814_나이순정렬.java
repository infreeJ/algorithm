package inbox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver5_10814_나이순정렬 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {

        int num = Integer.parseInt(br.readLine());

        int[] age = new int[num];
        String[] name = new String[num];

        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            age[i] = Integer.parseInt(input[0]);
            name[i] = input[1];
        }

        for (int i = 0; i < num; i++) {
            int tmpAge = 0;
            String tmpName = "";
            int tmpIndex = i; // 3
            for (int j = i+1; j < num; j++) {
                if(age[tmpIndex] > age[j]) {
                    tmpIndex = j;
                }
            }

            for(int j = tmpIndex; j > i; j--) {
                tmpAge = age[j];
                age[j] = age[j-1];
                age[j-1] = tmpAge;

                tmpName = name[j];
                name[j] = name[j-1];
                name[j-1] = tmpName;
            }
        }

        for(int i=0; i<num; i++) {
            bw.write(age[i] + " " + name[i]);
            bw.newLine();
        }
        bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
