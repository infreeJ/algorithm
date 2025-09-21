//package inbox;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//
//public class Silver3_1929_소수구하기 {
//    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        try {
//            String[] input = br.readLine().split(" ");
//            int min = Integer.parseInt(input[0]);
//            int max = Integer.parseInt(input[1]);
//
//            boolean isSuccess = true;
//            for (int i = min; i <= max; i++) {
//                if(i % 2 == 0 || i % 3 == 0) {
//                    i++;
//                }
//                for (int j = 2; j < i; j++) {
//                    if(i % j == 0) {
//                        isSuccess = false;
//                        break;
//                    }
//                }
//                if(isSuccess) {
//                    bw.write(String.valueOf(i));
//                    bw.newLine();
//                } else {
//                    isSuccess = true;
//                }
//            }
//
////            int tmp = 2;
////            while(min <= max) {
////                if(min <= 2) {
////                    bw.write(min);
////                    bw.newLine();
////                    min ++;
////                    continue;
////                }
////                if(min % tmp == 0) {
////
////                }
////
////            }
//
//            bw.flush();
//            bw.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
