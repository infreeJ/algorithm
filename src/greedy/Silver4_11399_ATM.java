package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Silver4_11399_ATM {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int t = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");

            ArrayList<Integer> times = new ArrayList<>();

            for (int i = 0; i < input.length; i++) {
                times.add(Integer.parseInt(input[i]));
            }

            times.sort(Comparator.naturalOrder());

            int sum = 0;
            int tmp = 0;
            for (int i = 0; i < times.size(); i++) {
                tmp += times.get(i);
                sum += tmp;
            }

            System.out.println(sum);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
