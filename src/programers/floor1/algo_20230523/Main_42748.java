package programers.floor1.algo_20230523;

import java.util.Arrays;

public class Main_42748 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(new Solution().solution(array, commands)));
    }
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        //[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
        //[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
        //[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.

        // for문1 ( 배열 commands[][]의 크기만큼 반복)
        for (int l = 0; l < commands.length; l++) {

            // int값 i, j, k를 구한다
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];

            int[] arrayTemp = new int[j-i + 1];
            if (true) {
                // int 배열 array 에서 i~j 사이의 값을 copy하여 새로운 배열을 만든다. 배열 arrayTemp
                arrayTemp = Arrays.copyOfRange(array, i-1, j);
            } else {
                // 혹은 for문으로 채워준다.
                // for문2 ( 배열 arrayTemp의 크기만큼 반복 )
                // 시작 i-1, 마지막 < j
                arrayTemp = new int[j-i + 1];
                for (int m = i-1, n = 0; m < j; m++, n++) {
                    arrayTemp[n] = array[m];
                }
            }

            // arrayTemp 를 정렬
            Arrays.sort(arrayTemp);

            // arrayTemp에서 k-1번째 갑슬 answer에 담아서 리턴
            answer[l] = arrayTemp[k-1];
        }

        return answer;
    }
}
