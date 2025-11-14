package greedy;

import java.util.Arrays;
import java.util.Scanner;

/*
접근 방법
1. 최소값을 구하려면 A의 가장 작은 수 x B의 가장 큰 수를 곱하고,
    B의 가장 작은 수 x A의 가장 큰 수를 곱해야 한다.
2. 문제의 식에는 B에 있는 수를 재배열하지말라고 하지만 출력에는 최소값만 내면 된다.
3. 따라서 A는 오름차순 정렬, B는 내림차순 정렬 후 for문으로 순환하며 합계를 내면 된다.
 */

public class Silver4_1026_보물 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        scan.nextLine();

        String[] input1 = scan.nextLine().split(" ");
        String[] input2 = scan.nextLine().split(" ");

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input1[i]);
            B[i] = Integer.parseInt(input2[i]);
        }

        // 오름차순 정렬
        Arrays.sort(A);

        // 람다식을 활용하여 내림차순 정렬
        Arrays.sort(B, (Integer n1, Integer n2) -> {
            return n2- n1;
        });

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i] * B[i];
        }

        System.out.println(sum);
    }
}
