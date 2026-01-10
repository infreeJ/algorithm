package sorting;

import java.io.*;
import java.util.*;

public class Gold4_23883_알고리즘수업선택정렬3 {

    /*
    접근 방법
    1. 입력을 받을 arr 배열과 arr 배열을 정렬한 sortedArr 배열을 정의한다.
    2. arr 배열의 값을 Key, 인덱스를 value로 가지는 HashMap을 선언한다.
    3. for문을 순환하며 sortedArr의 값을 이용해 HashMap에서 정확한 인덱스의 위치를 찾는다.
    4. arr의 순서를 교환하고 HashMap도 따라서 교환시킨다.
    5. 교환이 발생할 때마다 count 값을 증가시킨다.
    6. count가 K와 일치하면 교환된 쌍을 리턴한다.
     */

    /*
    책임 분리
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 선택 정렬을 수행하는 selectionSort 메서드
     */

    static int[] arr;
    static int[] sortedArr;
    static Map<Integer, Integer> arrMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        arr = new int[N];

        String[] arrStr = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        arrMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            arrMap.put(arr[i], i);
        }

        List<Integer> answer = selectionSort(K);

        StringBuilder sb = new StringBuilder();
        for(int i : answer) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString().trim());
    }


    static List<Integer> selectionSort(int K) {

        List<Integer> answer = new ArrayList<>();
        int count = 0;

        for(int i = arr.length-1; i >= 0; i--) {
            if(i != arrMap.get(sortedArr[i])) { // 현재 값이 정확한 위치가 아니라면
                count++;
                int targetIndex = arrMap.get(sortedArr[i]); // 교환이 필요한 인덱스를 찾는다.

                // arr 교환
                int tmp = arr[i];
                arr[i] = arr[targetIndex];
                arr[targetIndex] = tmp;

                // arrMap 교환
                arrMap.put(arr[i], i);
                arrMap.put(arr[targetIndex], targetIndex);

                if(count == K) {
                    answer.add(arr[targetIndex]);
                    answer.add(arr[i]);
                    return answer;
                }
            }
        }
        answer.add(-1);
        return answer;
    }
}
