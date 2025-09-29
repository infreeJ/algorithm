package inbox;

import java.util.Scanner;

public class Silver5_1789_수들의합 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        long input = scan.nextLong();
        scan.nextLine();

        long sum = 0;
        long count = 0;

        long i = 1;
        while (true) {
            sum += i;
            i++;
            count++;

            if(sum == input) {
                System.out.println(count);
                break;
            } else if(sum > input) {
                System.out.println(count-1);
                break;
            }
        }
        

        


//        int sum
//        int sum = 0;
//        for (int i = 1; i <= 10000; i++) {
//            sum += i;
//            if(i % 1000 == 0) {
//                System.out.println("i가 " + i + "일 때 " + "sum은 " + sum);
//            }
//        }
//        System.out.println(sum);
        // 10 단위 = 155, 255, 355
        // 100 단위 = 15050, 25050, 35050
        // 1000 단위 = 1500500, 2500500
        // 10000 단위 = 150005000, 250005000
        // 100000 단위 = 15000050000, 25000050000
    }
}
