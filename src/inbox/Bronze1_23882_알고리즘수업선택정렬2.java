package inbox;

import java.io.*;

public class Bronze1_23882_알고리즘수업선택정렬2 {

    /*
    접근 방법
    1. 선택정렬을 수행한다.
    2. 교환이 발생할 때마다 count 값을 증가시킨다.
    3. count가 K와 일치할 경우 현재의 배열을 출력한다.
     */

    /*
    책임 분리
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 선택 정렬을 수행하는 selectionSort 메서드
     */

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        String[] arrStr = br.readLine().split(" ");
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        boolean isSuccess = selectionSort(K);

        if(isSuccess) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println(-1);
        }


    }

    static boolean selectionSort(int K) {
        int count = 0;

        int point = 0;
        for(int i = arr.length-1; i >= 0; i--) {
            point = i;
            for(int j = 0; j < i; j++) {
                if(arr[point] < arr[j]) {
                    point = j;
                }
            }
            if(i != point) {
                count++;
                int tmp = arr[i];
                arr[i] = arr[point];
                arr[point] = tmp;
                if(count == K) return true;
            }
        }
        return false;
    }
}
