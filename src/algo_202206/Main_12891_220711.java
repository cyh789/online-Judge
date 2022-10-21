package algo_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 1. 시간복잡도 : 제한시간 2초.
//    최대가 1,000,000 이므로, O(n)의 시간복잡도 알고리즘으로 문제해결 필요
// 2. O(nm) : 그냥 계산 할 경우
// 3. O(n) : 부분 문자열 중 변하지 않는 값은 다시 계산하지 않을 경우(=맨 앞과 맨 뒤의 변하는 값만 다시 계산하는 경우)
//    슬라이딩 윈도우 알고리즘
//     - 2개의 포인터로 범위를 지정한 다음 범위를 유지한 채로 이동하며 문제를 해결
//     - O(n)
public class Main_12891_220711 {

    private static int[] checkArr;
    private static int[] myArr;
    private static int checkSecret;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());   //문자열의 크기
        int P = Integer.parseInt(st.nextToken());   //부분 문자열의 크기
        char[] a = br.readLine().toCharArray(); //문자열 데이터

        //비밀번호 체크 배열
        checkArr = new int[4];
        //현재 상태 배열
        myArr = new int[4];

        //몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수
        //4가 되면 전부 충족되었다는 것이므로 int result에 +1 한다
        checkSecret = 0;
        //출력 : 만들 수 있는 비밀번호의 종류의 수
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());

            // 0인경우 checkSecret가 1인 상태에서 시작(4가되면 int result에 + 1 한다)
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        // 1. 맨 처음(슬라이딩 윈도우 이동 전)
        for (int i = 0; i < P; i++) {
            add(a[i]);
        }
        //4가 되면 전부 충족되었다는 것이므로 int result에 +1 한다
        if (checkSecret == 4) {
            result++;
        }

        // 2. 슬라이딩 윈도우 이동
        for (int i = P; i < S; i++) {
            add(a[i]);
            remove(a[i-P]);     // P부터 시작이므로

            //4가 되면 전부 충족되었다는 것이므로 int result에 +1 한다
            if (checkSecret == 4) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (checkArr[0] == myArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (checkArr[1] == myArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (checkArr[2] == myArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (checkArr[3] == myArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (checkArr[0] == myArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (checkArr[1] == myArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (checkArr[2] == myArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (checkArr[3] == myArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}
