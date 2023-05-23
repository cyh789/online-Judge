package programers.floor1.algo_20230523;

import java.util.Arrays;

public class Main_12954 {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(Arrays.toString(new Solution_12954().solution(x, n)));
        x = 4; n = 3;
        System.out.println(Arrays.toString(new Solution_12954().solution(x, n)));
        x = -4; n = 2;
        System.out.println(Arrays.toString(new Solution_12954().solution(x, n)));
    }
}

class Solution_12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        /*
        x	n	answer
        2	5	[2,4,6,8,10]
        4	3	[4,8,12]
        -4	2	[-4, -8]
        */

        // for문 (n만큼 반복) {
        //      long cal은 x만큼 값이 커진다
        //      cal의 값을 long 배열 answer에 넣는다
        // }
        long cal = 0;
        if (false) {
            for (int i = 0; i < n; i++) {
                cal += x;
                answer[i] = cal;
            }
        } else {
            //혹은
            // for문 (n만큼 반복) {
            //      long cal은 x만큼 값이 커진다
            //      long xToLong 을 선언 후 x 의 값을 담아준다 (int x -> long x)
            //      x만큼 커진다는 것은 xToLong * (i + 1) 을 의미한다. cal = xToLong * (i + 1)
            //      cal의 값을 long 배열 answer에 넣는다
            // }
            long xToLong = x;
            for (int i = 0; i < n; i++) {
                cal = xToLong * (i + 1);
                answer[i] = cal;
            }
        }

        return answer;
    }
}