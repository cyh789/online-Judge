package programers.floor1.algo_20230524;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Main_68644 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,1,3,4,1};
        System.out.println(Arrays.toString(new Solution_68644().solution(numbers)));
        numbers = new int[]{5,0,2,7};
        System.out.println(Arrays.toString(new Solution_68644().solution(numbers)));
    }
}

class Solution_68644 {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        /*
        numbers	    result
        [2,1,3,4,1]	[2,3,4,5,6,7]
        [5,0,2,7]	[2,5,7,9,12]
         */

        // 정수 배열 numbers가 주어집니다.
        // numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아
        // 더해서 만들 수 있는 모든 수를
        // 배열에 담은 후
        //      중복된 수가 나올 수 있을 것이다 -> 중복된 숫자는 빼면 될듯 -> HashSet[] sum
        // 오름차순 정렬
        // 배열 return


        //      중복된 수가 나올 수 있을 것이다 -> 중복된 숫자는 빼면 될듯 -> HashSet[] sum
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length; j++) {
                // numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아
                if (i != j) {
                    // 배열에 담은 후
                    hs.add(numbers[i] + numbers[j]);
                }
            }
        }

        // Set -> Array
        answer = new int[hs.size()];
        Iterator<Integer> itor = hs.iterator();
        int anserIdx = 0;
        while (itor.hasNext()) {
            answer[anserIdx++] =itor.next();
        }

        // 오름차순 정렬
        Arrays.sort(answer);

        return answer;
    }
}