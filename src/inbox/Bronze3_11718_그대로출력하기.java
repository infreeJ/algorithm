package inbox;

import java.io.*;
import java.util.Scanner;

public class Bronze3_11718_그대로출력하기 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }

        scan.close();
    }
}
