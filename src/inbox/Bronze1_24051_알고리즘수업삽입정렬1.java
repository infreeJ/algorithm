package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1_24051_알고리즘수업삽입정렬1 {

    /*
    책임 분리
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 삽입 정렬을 실행하는 insertionSort 메서드
     */

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

        System.out.println(insertionSort(K));
    }


    static int insertionSort(int K) {

        int count = 0;
        int answer = -1;

        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int point = i;

            for(int j = i-1; j >= 0; j--) {
                if(arr[j] > tmp) {
                    count++;
                    arr[j+1] = arr[j];
                    point = j;
                    if(count == K) {
                        answer = arr[j];
                        return answer;
                    }
                } else {
                    break;
                }
            }

            if(point != i) {
                count++;
                arr[point] = tmp;
                if(count == K) {
                    answer = tmp;
                    return answer;
                }
            }
        }

        return answer;
    }
}







