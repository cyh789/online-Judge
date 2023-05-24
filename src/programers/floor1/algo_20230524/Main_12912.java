package programers.floor1.algo_20230524;

import java.util.Arrays;

public class Main_12912 {
    public static void main(String[] args) {
        System.out.println(new Solution_12912().solution(3, 5));
        System.out.println(new Solution_12912().solution(3, 3));
        System.out.println(new Solution_12912().solution(5, 3));
    }
}

class Solution_12912 {
    public long solution(int a, int b) {
        long answer = 0;

        /*
        a	b	return
        3	5	12
        3	3	3
        5	3	12
         */

        // a와 b 사이에 속한 모든 정수를 구한다. long number
        // 모든 정수의 합을 구한다. long sum

        long sum = 0;
        long aTemp = 0;
        if (a == b) {
            return a;
        } else if (a > b) {
            aTemp = b;
            b = a;
        } else {
            aTemp = a;
        }
        while (aTemp <= b) {
            long cal = aTemp++;
            sum += cal;
        }

        answer = sum;

        return answer;
    }
}