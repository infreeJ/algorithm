package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1_16396_선그리기 {
        /*
        접근방법
        - 10,000 크기의 boolean 배열을 만든다.
        - 선이 그려진 위치는 Y로 바꾼다
        - 배열을 순회하며 선이 그려진 위치는 count 값에 반영한다.
         */
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[10000];
        int count = 0;
        
        // 선 그리기
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            for (int j = a; j < b; j++) {
                arr[j-1] = true;
            }
        }

        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
