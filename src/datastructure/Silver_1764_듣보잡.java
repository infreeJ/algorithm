package datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver_1764_듣보잡 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);


            List<String> nList = new ArrayList<>();
            HashSet<String> mList = new HashSet<>();

            for (int i = 0; i < n; i++) {
                nList.add(br.readLine());
            }
            for (int i = 0; i < m; i++) {
                mList.add(br.readLine());
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if(mList.contains(nList.get(i))) {
                    count++;
                    sb.append(nList.get(i));
                    sb.append(",");
                }

            }

            String[] nmList = sb.toString().split(",");
            Arrays.sort(nmList);

            System.out.println(count);

            for (int i = 0; i < nmList.length; i++) {
                System.out.println(nmList[i]);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}