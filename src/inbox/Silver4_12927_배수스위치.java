package inbox;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Silver4_12927_배수스위치 {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] input = br.readLine().split("");
            ArrayList<Boolean> list = new ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                if(input[i].equals("Y")) {
                    list.add(true);
                } else {
                    list.add(false);
                }
            }

            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == true) {
                    System.out.println(i + "번 째 인덱스 true");
                    count++;
                    if(i == 0) {
                        for(int tmp = i+1; tmp < list.size()+1; tmp++) {
                            list.set(tmp-1, !list.get(tmp-1));
                        }
                    } else {
                        for(int tmp = i+1; tmp < list.size()+1; tmp += i+1) {
                            list.set(tmp-1, !list.get(tmp-1));
                        }
                    }

                }
            }
            System.out.println(count);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
