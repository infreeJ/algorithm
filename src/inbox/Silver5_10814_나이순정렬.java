//package inbox;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.Comparator;
//
//public class Silver5_10814_나이순정렬 {
//    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        try {
//
//            int t = Integer.parseInt(br.readLine());
//
//            ArrayList<String> list = new ArrayList<>();
//            for (int i = 0; i < t; i++) {
//                list.add(br.readLine());
//            }
//
//            list.sort(Comparator.naturalOrder());
//
//            for (int i = 0; i < t; i++) {
//                System.out.println(list.get(i));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//
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
