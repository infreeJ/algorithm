package inbox;

import java.util.Scanner;

public class Bronze2_3062_수뒤집기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCase = scan.nextInt();
        scan.nextLine();

        for(int i=0; i<testCase; i++) {
            int num = scan.nextInt();
            scan.nextLine();
            int numClone = num;

            int reversed = 0;
            while (numClone != 0) {
                int digit = numClone % 10;
                reversed = reversed * 10 + digit;
                numClone /= 10;
            }

            int sum = num + reversed;
            System.out.println("num = " + num);
            System.out.println("reversed = " + reversed);
            System.out.println("sum = " + sum);

            String[] sumArr = String.valueOf(sum).split("");

            int k = sumArr.length-1;
            System.out.println("시작 전 k는 " + k);
            boolean Yes = true;
            for(int j = 0; j <sumArr.length/2; j++) {
                System.out.println("현재 j는 " + j + "현재 k는 " + k + "  " + sumArr[j] + " / " + sumArr[k]);
                if(!sumArr[j].equals(sumArr[k])) {
                    Yes = false;
                    break;
                }
                k--;
            }


            if(Yes) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

        }
        System.out.println(sb.toString());
    }
}
