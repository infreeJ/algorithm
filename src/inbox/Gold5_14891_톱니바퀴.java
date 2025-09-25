package inbox;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Gold5_14891_톱니바퀴 {



    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> wheel1 = new ArrayList<>();
        ArrayList<Integer> wheel2 = new ArrayList<>();
        ArrayList<Integer> wheel3 = new ArrayList<>();
        ArrayList<Integer> wheel4 = new ArrayList<>();

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


            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                String[] tInput = br.readLine().split(" ");
                int number = Integer.parseInt(tInput[0]);
                int turn = Integer.parseInt(tInput[1]);

                boolean isLeftMatched;
                boolean isRightMatched;
                switch (number) {
                    case 1:
                        isRightMatched = wheel1.get(2).equals(wheel2.get(6));

                        if(turn == 1) {
                            wheel1.add(0, wheel1.remove(7));
                            System.out.println("1번 톱니바퀴가 시계방향으로 회전");
                            if(isRightMatched) {
                                wheel2.add(7, wheel2.remove(0));
                                System.out.println("2번 톱니바퀴가 반시계방향으로 회전");
                            }
                        } else if (turn == -1) {
                            wheel1.add(7, wheel1.remove(0));
                            System.out.println("1번 톱니바퀴가 반시계방향으로 회전");
                            if(isRightMatched) {
                                wheel2.add(0, wheel2.remove(7));
                                System.out.println("2번 톱니바퀴가 시계방향으로 회전");
                            }
                        }
                        break;
                    case 2:
                        isLeftMatched = wheel2.get(6).equals(wheel1.get(2));
                        isRightMatched = wheel2.get(2).equals(wheel3.get(6));

                        if(turn == 1) {
                            wheel2.add(0, wheel2.remove(7));
                            System.out.println("2번 톱니바퀴가 시계방향으로 회전");
                            if(isLeftMatched) {
                                wheel1.add(7, wheel1.remove(0));
                                System.out.println("1번 톱니바퀴가 반시계방향으로 회전");
                            }
                            if(isRightMatched) {
                                wheel3.add(7, wheel3.remove(0));
                                System.out.println("3번 톱니바퀴가 반시계방향으로 회전");
                            }
                        } else if (turn == -1) {
                            wheel2.add(7, wheel2.remove(0));
                            System.out.println("2번 톱니바퀴가 반시계방향으로 회전");
                            if(isLeftMatched) {
                                wheel1.add(0, wheel1.remove(7));
                                System.out.println("1번 톱니바퀴가 시계방향으로 회전");
                            }
                            if(isRightMatched) {
                                wheel3.add(0, wheel3.remove(7));
                                System.out.println("3번 톱니바퀴가 시계방향으로 회전");
                            }
                        }
                        break;
                    case 3:
                        isLeftMatched = wheel3.get(6).equals(wheel2.get(2));
                        isRightMatched = wheel3.get(2).equals(wheel4.get(6));

                        if(turn == 1) {
                            wheel3.add(0, wheel3.remove(7));
                            System.out.println("3번 톱니바퀴가 시계방향으로 회전");
                            if(isLeftMatched) {
                                wheel2.add(7, wheel2.remove(0));
                                System.out.println("2번 톱니바퀴가 반시계방향으로 회전");
                            }
                            if(isRightMatched) {
                                wheel4.add(7, wheel4.remove(0));
                                System.out.println("4번 톱니바퀴가 반시계방향으로 회전");
                            }
                        } else if (turn == -1) {
                            wheel3.add(7, wheel3.remove(0));
                            System.out.println("3번 톱니바퀴가 반시계방향으로 회전");
                            if(isLeftMatched) {
                                wheel2.add(0, wheel2.remove(7));
                                System.out.println("2번 톱니바퀴가 시계방향으로 회전");
                            }
                            if(isRightMatched) {
                                wheel4.add(0, wheel4.remove(7));
                                System.out.println("4번 톱니바퀴가 시계방향으로 회전");
                            }
                        }
                        break;
                    case 4:
                        isLeftMatched = wheel4.get(6).equals(wheel3.get(2));

                        if(turn == 1) {
                            wheel4.add(0, wheel4.remove(7));
                            System.out.println("4번 톱니바퀴가 시계방향으로 회전");
                            if(isLeftMatched) {
                                wheel3.add(7, wheel3.remove(0));
                                System.out.println("3번 톱니바퀴가 반시계방향으로 회전");
                            }
                        } else if (turn == -1) {
                            wheel4.add(7, wheel4.remove(0));
                            System.out.println("4번 톱니바퀴가 반시계방향으로 회전");
                            if(isLeftMatched) {
                                wheel3.add(0, wheel3.remove(7));
                                System.out.println("3번 톱니바퀴가 시계방향으로 회전");
                            }
                        }
                        break;
                }
            }

            for (int i = 0; i < wheel1.size(); i++) {
                System.out.print(wheel1.get(i));
            }
            System.out.println();
            for (int i = 0; i < wheel2.size(); i++) {
                System.out.print(wheel2.get(i));
            }
            System.out.println();
            for (int i = 0; i < wheel3.size(); i++) {
                System.out.print(wheel3.get(i));
            }
            System.out.println();
            for (int i = 0; i < wheel4.size(); i++) {
                System.out.print(wheel4.get(i));
            }
            System.out.println();

            int score = 0;
            if(wheel1.get(0) == 1) {
                score += 1;
            }
            if(wheel2.get(0) == 1) {
                score += 2;
            }
            if(wheel3.get(0) == 1) {
                score += 4;
            }
            if(wheel4.get(0) == 1) {
                score += 8;
            }


            System.out.println(score);




        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
