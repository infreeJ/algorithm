package implementation;


import java.util.Scanner;

public class Bronze2_8958_OX퀴즈 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();
        scan.nextLine();
        String ox;
        for (int i = 0; i < input; i++) {
            ox = scan.nextLine();
            int tmp = 0;
            int sum = 0;

            for (int j = 0; j < ox.length(); j++) {

                if (ox.charAt(j) == 'O') {
                    tmp++;
                    sum += tmp;
                } else {
                    tmp = 0;
                }

            }
            System.out.println(sum);
            sum = 0;
        }
    }
}
