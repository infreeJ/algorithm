package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2_3052_나머지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] arr = new int[42];
        for (int i = 0; i < 10; i++) {
            arr[Integer.parseInt(br.readLine()) % 42]++;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
