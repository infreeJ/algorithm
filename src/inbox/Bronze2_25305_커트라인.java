package inbox;

import java.util.Arrays;
import java.util.Scanner;

public class Bronze2_25305_커트라인 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String[] input2 = scan.nextLine().split(" ");

        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(arr, (Integer a, Integer b) -> {
            return b - a;
        });

        System.out.println(arr[k-1]);
    }
}
