package programers_floor_1_202305;

import java.util.Arrays;

public class Main_42748 {

    public static void main(String[] args) throws Exception {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = {5, 6, 3};
//        int[] answer = new int[3];

        //[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
        //[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
        //[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.


        int[] answer = new int[commands.length];
        for (int l = 0; l < commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];

            int[] arr2 = new int[j-i + 1];
            for (int m = i-1, o = 0; m < j; m++, o++) {
                arr2[o] = array[m];
            }

            Arrays.sort(arr2);

            answer[l] = arr2[k-1];
        }

        System.out.println(Arrays.toString(answer));
    }
}
