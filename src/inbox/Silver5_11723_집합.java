package inbox;

import java.io.*;
import java.util.HashSet;

public class Silver5_11723_집합 {

    // 기본적으로 사용할 Set
    static HashSet<Integer> set = new HashSet<>();

    // all 입력을 받으면 덮어씌울 Set
    static HashSet<Integer> initSet = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 20; i++) {
            initSet.add(i); // 1~20 까지 초기화
        }

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            String method = input[0]; // 입력 메서드
            int x = 0;
            
            // x가 필요한 메서드만 x값 대입
            if(!method.equals("all") && !method.equals("empty")) {
                x = Integer.parseInt(input[1]);
            }


            // 입력별 메서드 실행
            switch (method) {
                case "add":
                    set.add(x);
                    break;
                case "remove":
                    set.remove(x);
                    break;
                case "check":
                    if (set.contains(x)) {
                        bw.write(String.valueOf(1));
                        bw.newLine();
                    } else {
                        bw.write(String.valueOf(0));
                        bw.newLine();
                    }
                    break;
                case "toggle":
                    if (set.contains(x)) {
                        set.remove(x);
                    } else {
                        set.add(x);
                    }
                    break;
                case "all":
                    set = new HashSet<>(initSet);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
