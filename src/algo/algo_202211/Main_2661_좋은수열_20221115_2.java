package algo.algo_202211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2661_좋은수열_20221115_2 {

    // 1. 좋은 수열의 가장 작은 수를 도출해내는 func() 함수의 작업은 아래와 같다.
    //   - 만약 data 문자열의 길이가 n과 같다면 data를 출력하고 시스템을 종료한다.
    //   - 그렇지 않다면 값을 더 추가해야하므로, 반복문을 통해 작은 수 순서로 값을 추가한다.
    //   - 만약 해당 문자열이 좋은수열이라면 func() 함수를 재귀호출한다.
    //
    // 2. 전달받은 값이 좋은수열인지 판별하는 check() 함수의 작업은 아래와 같다.
    //   - 1부터 index의 절반까지를 반복문의 범위로 하여 해당 길이의 인접한 두 개의 부분 수열이 동일한 것이 있으면 false를 반환한다.
    //   - 반복문이 끝날때까지도 -1이 반환되지 않았다면 좋은수열이므로 true를 반환한다.

    public static void main(String[] args) throws IOException {

        String s = "12321";

        System.out.println(extracted(s));
    }

    private static String extracted(String s) {
        int length = s.length() / 2;
        for (int i = 1; i <= length; i++) {
            System.out.println("==================================");
            System.out.println("left=" + s.substring(s.length() - i)  );
            System.out.println("left length start=" + (s.length() - i));
            System.out.println("right=" + s.substring(s.length() - 2 * i, s.length() - i)  );
            System.out.println("right length start=" + (s.length() - 2 * i)  );
            System.out.println("right length end=" + (s.length() - i)  );
            if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
                return "false";
            }
            System.out.println("==================================");
            System.out.println("");
        }
        return "true";
    }
}





























