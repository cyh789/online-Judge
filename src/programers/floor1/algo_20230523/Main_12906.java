package programers.floor1.algo_20230523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main_12906 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(new Solution_12906().solution(arr)));
        arr = new int[]{4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(new Solution_12906().solution(arr)));
    }
}

class Solution_12906 {
    public int[] solution(int []arr) {
        int[] answer = {};
        /*
        arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
        arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
        */

        // for문 ( 배열 arr의 크기만큼 반복 ) {
        //      연속적으로 나타나는 숫자가 있는지 확인
        //          int prev에 이전 값을 넣고 비교
        //      연속적으로 나타나는 숫자는 하나만 남기고 전부 제거
        //          prev와 비교해서 다른 값인 경우에만 answerList LinkedList에 담음(answer는 크기를 알 수 없으므로 LinkedList로 선언)
        //          prev와 비교해서 다른 값인 경우에만 prev 값을 교체
        //      answerList에 arr배열의 첫번째 값은 넣고 시작 할 것
        //      for문의 시작값은 0이 아니라 1이다.
        // }
        if (false) {
            ArrayList<String> answerList = new ArrayList();
            String prevStr = String.valueOf(arr[0]);
            answerList.add(prevStr);
            for (int i = 1; i < arr.length; i++) {
                if (!Objects.equals(prevStr, String.valueOf(arr[i]))) {
                    prevStr = String.valueOf(arr[i]);
                    answerList.add(prevStr);
                }
            }

            // List를 Array로 바꿔준다
            String[] answerStr = answerList.toArray(new String[answerList.size()]);

            answer = new int[answerStr.length];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = Integer.valueOf(answerStr[i]);
            }

            return answer;
        } else {
            ArrayList<Integer> answerList = new ArrayList();
            int prev = arr[0];
            answerList.add(prev);
            for (int i = 1; i < arr.length; i++) {
                if (!Objects.equals(prev, arr[i])) {
                    prev = arr[i];
                    answerList.add(prev);
                }
            }

            // List를 Array로 바꿔준다
            answer = new int[answerList.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }
        }

        return answer;
    }
}