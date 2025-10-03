package sorting;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Silver5_10814_나이순정렬 {

    static class AgeComparator implements Comparator<String[]> {
        @Override
        public int compare(String[] mem1, String[] mem2) {
            return Integer.parseInt(mem1[0]) - Integer.parseInt(mem2[0]);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        String[][] members = new String[t][2];

        for (int i = 0; i < t; i++) {
            members[i][0] = scan.next();
            members[i][1] = scan.next();
        }

        Arrays.sort(members, new AgeComparator());

        for(int i = 0; i < t; i++) {
            System.out.println(members[i][0] +" "+ members[i][1]);
        }
    }
}