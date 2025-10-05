package sorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Silver5_2751_수정렬하기2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scan.nextInt();
        scan.nextLine();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list.add(scan.nextInt());
            scan.nextLine();
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        try {
            for (int i = 0; i < t; i++) {
                bw.write(String.valueOf(list.get(i)));
                bw.newLine();
            }

            bw.flush();
            bw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
