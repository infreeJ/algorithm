package inbox;

import java.io.*;
import java.util.ArrayList;

public class Gold5_14891_톱니바퀴2 {


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> wheel1 = new ArrayList<>();
        ArrayList<Integer> wheel2 = new ArrayList<>();
        ArrayList<Integer> wheel3 = new ArrayList<>();
        ArrayList<Integer> wheel4 = new ArrayList<>();

        ArrayList<ArrayList<Integer>> wheels = new ArrayList<>();

        try {

            String[] input1 = br.readLine().split("");
            String[] input2 = br.readLine().split("");
            String[] input3 = br.readLine().split("");
            String[] input4 = br.readLine().split("");

            for (int i = 0; i < 8; i++) {
                wheel1.add(Integer.parseInt(input1[i]));
                wheel2.add(Integer.parseInt(input2[i]));
                wheel3.add(Integer.parseInt(input3[i]));
                wheel4.add(Integer.parseInt(input4[i]));
            }

            wheels.add(wheel1);
            wheels.add(wheel2);
            wheels.add(wheel3);
            wheels.add(wheel4);



            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                String[] tInput = br.readLine().split(" ");
                int number = Integer.parseInt(tInput[0]) - 1;
                int turn = Integer.parseInt(tInput[1]);

                boolean isLeftMatched = false;
                boolean isRightMatched = false;


                for (int j = number; j >= 0; j--) { // 내려가면서
                    if (j != 0) { // 왼쪽 톱니바퀴와 같은지 비교
                        isLeftMatched = wheels.get(j).get(6).equals(wheels.get(j - 1).get(2));
                    }

                    if (turn == 1) { // 현재 톱니바퀴를 지시에 따라 회전
                        wheels.get(j).add(0, wheels.get(j).remove(7));
                        if (isLeftMatched) {
                            wheels.get(j-1).add(7, wheels.get(j-1).remove(0));
                        }
                    } else {
                        wheels.get(j).add(7, wheels.get(j).remove(0));
                        if (isLeftMatched) {
                            wheels.get(j-1).add(0, wheels.get(j-1).remove(7));
                        }
                    }
                    isLeftMatched = false; // 값 초기화
                }

                if (number != 3) { // number+1이 배열 밖일 수도 있으니 검증
                    for (int j = number + 1; j < 4; j++) { // 올라가면서
                        if (j != 3) { // 오른쪽 톱니바퀴와 같은지 비교
                            isRightMatched = wheels.get(j).get(2).equals(wheels.get(j+1).get(6));
                        }

                        if (turn == 1) { // 현재 톱니바퀴를 지시에 따라 회전
                            wheels.get(j).add(0, wheels.get(j).remove(7));
                            if (isRightMatched) {
                                wheels.get(j+1).add(7, wheels.get(j+1).remove(0));
                            }
                        } else {
                            wheels.get(j).add(7, wheels.get(j).remove(0));
                            if (isRightMatched) {
                                wheels.get(j+1).add(0, wheels.get(j+1).remove(7));
                            }
                        }
                        isRightMatched = false; // 값 초기화
                    }
                }


            }
        } catch (IOException e) {
            System.out.println(e);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(wheels.get(i).get(j));
            }
            System.out.println();
        }



        int score = 0;
        if (wheels.get(0).get(0) == 1) {
            score += 1;
        }
        if (wheels.get(1).get(0) == 1) {
            score += 2;
        }
        if (wheels.get(2).get(0) == 1) {
            score += 4;
        }
        if (wheels.get(3).get(0) == 1) {
            score += 8;
        }


        System.out.println(score);


    }

}


