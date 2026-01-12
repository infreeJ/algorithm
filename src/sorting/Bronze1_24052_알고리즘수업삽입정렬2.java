package sorting;

import java.io.*;

public class Bronze1_24052_알고리즘수업삽입정렬2 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        arr = new int[N];

        String[] input2 = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        if(insertionSort(K)) {
            StringBuilder sb = new StringBuilder();
            for(int i : arr) {
                sb.append(i);
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println(-1);
        }
    }

    static boolean insertionSort(int K) {
        int count = 0;

        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int point = i;
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] > tmp) {
                    count++;
                    arr[j+1] = arr[j];
                    point = j;
                    if(count == K) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            if(point != i) {
                count++;
                arr[point] = tmp;
                if(count == K) {
                    return true;
                }
            }
        }

        return false;
    }
}





