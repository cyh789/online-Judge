package programers.floor1.algo_20230524;

import java.util.ArrayList;
import java.util.Arrays;

public class Main_12910 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 7, 10};
        int divisor = 5;
        System.out.println( Arrays.toString(new Solution_12910().solution(arr, divisor)) );
        arr = new int[]{2, 36, 1, 3};
        divisor = 1;
        System.out.println( Arrays.toString(new Solution_12910().solution(arr, divisor)) );
        arr = new int[]{3,2,6};
        divisor = 10;
        System.out.println( Arrays.toString(new Solution_12910().solution(arr, divisor)) );
    }
}

class Solution_12910 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        /*
        array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
        divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
         */

        /*
        arr	divisor	return
        [5, 9, 7, 10]	5	[5, 10]
        [2, 36, 1, 3]	1	[1, 2, 3, 36]
        [3,2,6]     	10	[-1]
         */

        // array의 각 element 중 divisor로 나누어 떨어지는 값을 찾아서 배열에 담는다. int[] arrFromDivisor
        // int[] arrFromDivisor 배열의 값을 오름차순으로 정렬한다.
        // divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환한다.

        ArrayList<Integer> listFromDivisor = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // array의 각 element 중 divisor로 나누어 떨어지는 값을 찾아서 배열에 담는다. int[] arrFromDivisor
            if (arr[i] % divisor == 0) {
                listFromDivisor.add(arr[i]);
            }
        }

        // divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환한다.
        if (listFromDivisor.size() <= 0) {
            return new int[]{-1};
        }

        answer = new int[listFromDivisor.size()];
        for (int i = 0; i < listFromDivisor.size(); i++) {
            answer[i] = listFromDivisor.get(i);
        }

        // int[] arrFromDivisor 배열의 값을 오름차순으로 정렬한다.
        Arrays.sort(answer);

        return answer;
    }
}