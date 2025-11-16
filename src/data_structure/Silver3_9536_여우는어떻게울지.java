package data_structure;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Silver3_9536_여우는어떻게울지 {
    public static void main(String[] args) throws IOException {

        /*
        접근 방법
        - 녹음된 소리를 담을 List를 만든다.
        - 3번째 줄부터 what does the fox say?가 나오기 전까지
            각 동물의 울음 소리가 있는 2번 인덱스의 값을 list.removeAll로 삭제한다.
        - 남은 소리를 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            List<String> recording = new ArrayList<>(List.of(input));


            while(true) {
                String animalInfo = br.readLine();
                if(animalInfo.equals("what does the fox say?")) {
                    break;
                }
                String[] animalSound = animalInfo.split(" ");
                recording.removeAll(Collections.singleton(animalSound[2]));

            }

            for (int j = 0; j < recording.size(); j++) {
                bw.append(recording.get(j));
                if(j == recording.size() -1) {
                    bw.newLine();
                    break;
                }
                bw.append(" ");
            }

        }

        bw.flush();
        bw.close();

    }
}

