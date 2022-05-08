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

        //1. N까지 + 또는 - 버튼으로만 움직이는 경우
        //단순히 Math.abs로 계산하면 된다.
        int ans = Math.abs(n - 100);

        //2. N과 가까운 번호를 누른 후, + 또는 - 버튼으로 움직이는 경우
        //고장 난 버튼을 제외할 방법을 생각해 주어야 한다.
        //possible_1107 함수에서 모듈러(%)를 사용하여 한자리씩 고장 난 버튼인지 확인하고,
        //고장 난 버튼이 하나라도 포함되어 있다면 누를 수 없는 번호이므로 return 0 해준다.
        //그러고 나서 숫자 버튼 누르는 횟수 + 방향 버튼 누르는 횟수가 더 작은 값인지 확인해 준다.
        for (int i = 0; i <= 999999; i++) {
            //c로 숫자버튼만을 이용해서 이동이 가능한지, 가능하다면 몇 번의 버튼을 누르는지 구하는 변수
            int len = possible_1107(i);
            if (len > 0) {
                //숫자버튼으로 n에 최대한 인접하게 이동한후 +또는 -를 몇 번 눌러야 하는지 구하는 변수
                int press = i - n;
                if (press < 0) press = -press;

                // 최소 이동 횟수 계산
                if (ans > len + press) {
                    ans = len + press;
                }
            }
        }
        System.out.println(ans);
    }

    private static int possible_1107(int c) {
        if (c == 0) { //0일때 예외처리
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (c > 0) {
            // 고장난 버튼이 있는 경우
            if (broken[c % 10]) {
                return 0;
            }
            // 숫자버튼 누르는 횟수 증가
            len += 1;
            c /= 10;
        }
        return len;
    }

    //테트로미노
    static int[][][] BLOCKS_14500 = {
            //19 4 2
            {{0,0}, {0,1}, {0,2}, {0,3}}
            ,{{0,0}, {1,0}, {2,0}, {3,0}}
            ,{{0,0}, {1,0}, {0,1}, {1,1}}
            ,{{0,0}, {0,1}, {0,2}, {1,2}}
            ,{{0,0}, {1,0}, {2,0}, {0,1}}
            ,{{0,0}, {1,0}, {1,1}, {1,2}}
            ,{{2,0}, {0,1}, {1,1}, {2,1}}
            ,{{1,0}, {1,1}, {1,2}, {0,2}}
            ,{{0,0}, {0,1}, {1,1}, {2,1}}
            ,{{0,0}, {1,0}, {0,1}, {0,2}}
            ,{{0,0}, {1,0}, {2,0}, {2,1}}
            ,{{0,0}, {1,0}, {2,0}, {1,1}}
            ,{{1,0}, {0,1}, {1,1}, {1,2}}
            ,{{0,1}, {1,0}, {1,1}, {2,1}}
            ,{{0,0}, {0,1}, {0,2}, {1,1}}
            ,{{0,0}, {0,1}, {1,1}, {1,2}}
            ,{{0,1}, {1,1}, {1,0}, {2,0}}
            ,{{1,0}, {1,1}, {0,1}, {0,2}}
            ,{{0,0}, {1,0}, {1,1}, {2,1}}
    };
    public static void bf_14500(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        //전체 블록을 지정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                //4개의 큐브로 이루어진 도형 19개를 확인
                for (int k = 0; k < 19; k++) {
                    boolean ok = true;
                    //큐브의 값
                    int sum = 0;
                    for (int l = 0; l < 4; l++) {
                        //큐브의 x좌표
                        int x = i + BLOCKS_14500[k][l][0];
                        //큐브의 y좌표
                        int y = j + BLOCKS_14500[k][l][1];

                        //큐브 4개의 값을 모두 구한다
                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            //큐브의 값 = a[x][y]
                            sum += a[x][y];
                        } else {
                            ok = false;
                            break;
                        }
                    }

                    if (ok && ans < sum ) ans = sum;
                }

            }
        }

        System.out.println(ans);
    }
}







































