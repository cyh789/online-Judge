package algo.algo_202211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2661_좋은수열_20221116 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        func("", n);
    }

    private static void func(String s, int n) {
        if (s.length() == n) {
            System.out.println(s);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (check(s + i)) {
                func(s + i, n);
            }
        }
    }

    private static boolean check(String s) {
        int length = s.length() / 2;
        for (int i = 1; i <= length; i++) {
            if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
                return false;
            }
        }
        return true;
    }
}





























