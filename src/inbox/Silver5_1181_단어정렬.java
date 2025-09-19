package inbox;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Silver5_1181_단어정렬 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int t = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();

            for (int i = 0; i < t; i++) {
                list.add(br.readLine());
            }

            list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));


            String tmp = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if(tmp.equals(list.get(i))) {
                    list.remove(i);
                    i--;
                } else {
                    tmp = list.get(i);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
