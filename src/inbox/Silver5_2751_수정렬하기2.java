package inbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Silver5_2751_수정렬하기2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        scan.nextLine();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list.add(scan.nextInt());
            scan.nextLine();
        }

        list.sort(Comparator.naturalOrder());

        for (int i = 0; i < t; i++) {
            System.out.println(list.get(i));
        }
    }
}
