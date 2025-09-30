package inbox;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Silver5_10814_나이순정렬 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int t = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();

            // 같은 나이의 회원이 나오는 순으로 번호를 매길 배열
            int[] age = new int[200];
            Arrays.fill(age, 0);

            for (int i = 0; i < t; i++) {
                String[] input = br.readLine().split(" ");
                age[Integer.parseInt(input[0])-1]++; // 입력된 나이의 배열을 1 증가

                // 나이 번호를 조합
                String info = age[Integer.parseInt(input[0])-1] + " " + input[0] + " " + input[1];

                list.add(info);
            }

            // 나이순, 나이번호 순으로 정렬
//            list.sort(Comparator.);

            // 나이 번호 제거
            for (int i = 0; i < list.size(); i++) {
                String[] tmp = list.get(i).split(" ");
                list.set(i, tmp[1] + " " + tmp[2]);
            }
            
            for (int i = 0; i < t; i++) {
                System.out.println(list.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



//10
//25 qwdas
//35 asac
//2 abfwfwf
//185 asfvv
//120 asffcbxb
//35 dacx
//17 enttnt
//2 vdfbfd
//25 dvdve
//119 eefww