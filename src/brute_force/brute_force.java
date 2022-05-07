package brute_force;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class brute_force {

    //아홉난쟁이 문제
    public static void bf_2309(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] intArr = new int[9];
        int sum = 0;
        int highA = 0;
        int highB = 0;
        
        //난쟁이 9명의 키의 합을 구함
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = sc.nextInt();
            sum += intArr[i];
        }
        
        //오름차순 정렬
        Arrays.sort(intArr);

        //키의 합에서 2명의 키를 뺀 값이 100이라면 break;
        for (int i = 0; i < intArr.length-1; i++) {
            for (int j = i+1; j < intArr.length; j++) {
                if (sum - intArr[i] - intArr[j] == 100) {
                    highA = i;
                    highB = j;
                    break;
                }
            }
        }

        //나머지 난쟁이 7명의 값을 출력
        for (int i = 0; i < intArr.length; i++) {
            if (i == highA || i == highB) {
                continue;
            }
            System.out.println(intArr[i]);
        }

//        sc.close();
        System.exit(0);
    }

    //사탕게임
    public static void bf_3085(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] a = new char[n][n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n-1) {
                    char t = a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j+1] = t;

                    int temp = getChk_bf_3085(a);
                    if (ans < temp) ans = temp;

                    t = a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j+1] = t;
                }
                if (i < n-1) {
                    char t = a[i][j];
                    a[i][j] = a[i+1][j];
                    a[i+1][j] = t;

                    int temp = getChk_bf_3085(a);
                    if (ans < temp) ans = temp;

                    t = a[i][j];
                    a[i][j] = a[i+1][j];
                    a[i+1][j] = t;
                }
            }
        }

        System.out.println(ans);
    }

    private static int getChk_bf_3085(char[][] a) {
        int n = a.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (a[i][j] == a[i][j-1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }

            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (a[j][i] == a[j-1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
        }

        return ans;
    }

    //날짜계산
    public static void bf_1476(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt() -1;
        int s = sc.nextInt() -1;
        int m = sc.nextInt() -1;
        for (int i = 0; ; i++) {
            if (i%15==e && i%28==s && i%19==m) {
                System.out.println(i +1);
                break;
            }
        }
    }

    //리모컨

    static boolean[] broken = new boolean[10];
    public static void bf_1107(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 이동 원하는 채널
        int m = sc.nextInt(); // 고자안 채널 갯수
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            broken[x] = true; // 트루면 고장!
        }

        int ans = Math.abs(n - 100);

        for (int i = 0; i <= 999999; i++) {
            int len = possible(i);
            if (len > 0) {
                int press = i - n;
                if (press < 0) press = -press;

                if (ans > len + press) {
                    ans = len + press;
                }
            }
        }
        System.out.println(ans);
    }

    private static int possible(int c) {
        if (c == 0) { //0일때 예외처리
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (c > 0) {
            if (broken[c % 10]) {
                return 0;
            }
            len += 1;
            c /= 10;
        }
        return len;
    }
}







































