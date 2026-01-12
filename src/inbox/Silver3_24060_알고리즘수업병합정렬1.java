package inbox;

import java.io.*;

public class Silver3_24060_알고리즘수업병합정렬1 {

    static int[] arr;
    static int[] tmp;

    static int K;
    static int count = 0;
    static int result = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        K = Integer.parseInt(input1[1]);

        arr = new int[N];
        tmp = new int[N];

        String[] input2 = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        mergeSort(0, N-1);

        System.out.println(result);
    }

    static void mergeSort(int start, int end) {

        if(count >= K) return;

        if(start < end) {
            int mid = (start + end) / 2;

            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, mid, end);
        }
    }

    static void merge(int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = 0;

        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        while(i <= mid) {
            tmp[t++] = arr[i++];
        }
        while(j <= end) {
            tmp[t++] = arr[j++];
        }

        i = start;
        t = 0;

        while(i <= end) {
            arr[i] = tmp[t++];
            count++;

            if(count == K) {
                result = arr[i];
                return;
            }
            i++;
        }
    }
}






