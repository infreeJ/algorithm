package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3_27162_YachtDice {

    static int[] num = new int[3];
    static int maxScore = 0; // 최대 점수

    /**
     * 1~6번 족보 (지정한 숫자의 총합)
     * @param number 지정한 숫자
     */
    private static int numbers(int number) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if(num[i] == number) {
                count++;
            }
        }
        return number * (count+2);
    }

    /**
     * 동일한 주사위 눈이 4개 이상이라면, 동일한 주사위 눈 * 4
     * 나와있는 3개의 눈 중 2개가 일치한다면 조건에 부합된다.
     */
    private static int fourOfAKind() {
        int[] tmp = new int[6];

        for (int i = 0; i < 3; i++) {
            tmp[num[i]-1]++;
        }

        int max = 0;
        for (int i = 0; i < 6; i++) {
            if(tmp[i] == 2 || tmp[i] == 3) {
                max = i+1;
                break;
            }
        }
        return max * 4;
    }

    /**
     * 주사위 눈이 정확히 두 종류로 이루어져 있고 한 종류는 3개, 다른 종류는 2개일 때, 주사위 눈 5개의 총합
     */
    private static int fullHouse() {
        
        // 3개의 눈이 모두 같은 경우
        if(num[0] == num[1] && num[0] == num[2]) {
            int score = 0;
            if(num[0] == 6) {
                return num[0] + num[1] + num[2] + 10;
            } else {
                return num[0] + num[1] + num[2] + 12;
            }
        }
        
        // 3개의 눈이 모두 다른 경우
        if(num[0] != num[1] && num[0] != num[2] && num[1] != num[2]) {
            return 0;
        }

        // 2개만 같고 나머지 1개는 다를 경우

        int maxNumber = 0;
        int minNumber = 6;
        for (int i = 0; i < 3; i++) {
            if(maxNumber < num[i]) {
                maxNumber = num[i];
            }
            if(minNumber > num[i]) {
                minNumber = num[i];
            }
        }

        return maxNumber * 3 + minNumber * 2;
    }

    /**
     * Little Straight, Big Straight
     * 1에서 5까지의 눈이 하나씩 있다면 30점 (min = 0, max = 5)
     * 2에서 6까지의 눈이 하나씩 있다면 30점 (min = 1, max = 6)
     */
    private static int straight(String index) {

        if(index.equals("little")) {
            if(num[0] != 6 && num[1] != 6 && num[2] != 6) {
                if(num[0] != num[1] && num[0] != num[2] && num[1] != num[2]) {
                    return 30;
                }
            }
        }

        if(index.equals("big")) {
            if(num[0] != 1 && num[1] != 1 && num[2] != 1) {
                if(num[0] != num[1] && num[0] != num[2] && num[1] != num[2]) {
                    return 30;
                }
            }
        }

        return 0;
    }


    /**
     * 동일한 눈이 5개라면 50점
     */
    static int yacht() {
        if(num[0] == num[1] && num[0] == num[2]) {
            return 50;
        } else {
            return 0;
        }
    }

    /**
     * 모든 주사위 눈의 총합
     */
    static int choice() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += num[i];
        }

        return sum + 12;
    }


    /**
     * 족보들을 모두 실행하여 최대 점수를 구하는 메서드
     * @return 최대 점수
     */
    private static int getMaxScore(boolean[] combinations) {

        // numbers 메서드 호출
        for (int i = 0; i < 6; i++) {
            if(combinations[i]) {
                int numbersScore = 0;
                numbersScore = numbers(i+1);

                if(maxScore < numbersScore) {
                    maxScore = numbersScore;
                }
            }
        }


        if(combinations[6]) {
            // fourOfAKindScore 메서드 호출
            int fourOfAKindScore = fourOfAKind();

            if(maxScore < fourOfAKindScore) {
                maxScore = fourOfAKindScore;
            }
        }


        if(combinations[7]) {
            // fullHouse 메서드 호출
            int fullHouseScore = fullHouse();

            if (maxScore < fullHouseScore) {
                maxScore = fullHouseScore;
            }
        }



        if(combinations[8]) {
            String index = "little";
            // straight 메서드 호출 (0, 5)
            int littleStraightScore = straight(index);

            if (maxScore < littleStraightScore) {
                maxScore = littleStraightScore;
            }
        }


        if(combinations[9]) {
            String index = "big";
            // straight 메서드 호출 (1, 6)
            int BigStraightScore = straight(index);

            if (maxScore < BigStraightScore) {
                maxScore = BigStraightScore;
            }
        }


        if(combinations[10]) {
            // yacht 메서드 호출
            int yachtScore = yacht();

            if (maxScore < yachtScore) {
                maxScore = yachtScore;
            }
        }


        if(combinations[11]) {
            // choice 메서드 호출
            int choiceScore = choice();

            if (maxScore < choiceScore) {
                maxScore = choiceScore;
            }
        }


        return maxScore;
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");
        String[] input2 = br.readLine().split(" ");

        boolean[] combinations = new boolean[input.length];

        for (int i = 0; i < combinations.length; i++) {
            combinations[i] = input[i].equals("Y");
        }

        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(input2[i]);
        }

        System.out.println(getMaxScore(combinations));
    }


}
