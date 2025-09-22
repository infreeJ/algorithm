package inbox;

import java.util.ArrayList;
import java.util.Scanner;

public class Silver4_11866_요세푸스문제0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String[] input = scan.nextLine().split(" ");

        int person = Integer.parseInt(input[0]);
        int remove = Integer.parseInt(input[1]);

        ArrayList<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= person; i++) {
            circle.add(i);
        }

        int tmp = remove - 1;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < person; i++) {
            result.add(circle.remove(tmp));
            tmp += remove -1;
            if(tmp >= circle.size() && !circle.isEmpty()) {
                tmp %= circle.size();
            }
        }

        sb.append("<");
        for (int i = 0; i < result.size() -1; i++) {
            sb.append(result.get(i));
            sb.append(", ");
        }
        sb.append(result.get(result.size()-1));
        sb.append(">");
        System.out.println(sb);
    }
}
