package bf_backtrack_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_220630 {

//    private static int count;
    private static boolean[] visit;
    private static int result;
    private static int[][] a;
    private static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;

        visit = new boolean[n];
//        count = 0;
        dfs_14889_220630(0, 0);

        System.out.println(result);
    }

    // depth: 깊이. count: 팀의 능력치 조합 개수(=팀원 개수)
    private static void dfs_14889_220630(int depth, int count) {
        // 조건을 n/2 로 지정해야 boolean[]으로 팀을 나눌 수 있음. ex) 4, true(2), false(2)
        if (count == n/2) {
            // 방문한 팀과 방문하지 않은 팀을 각각 나누어 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
            compare_14889_220630();
            return;
        }

        // 시작점을 depth로 지정해야 백트래킹 가능
        for (int i = depth; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
//                count += 1;   // i(현재 depth) 와 count는 동일하게 증감해야 한다
                dfs_14889_220630(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    private static void compare_14889_220630() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                // i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수를 더해준다.
                if (visit[i] == true && visit[j] == true) {
                    start += a[i][j];
                    start += a[j][i];
                    // i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수를 더해준다.
                } else if (visit[i] == false && visit[j] == false) {
                    link += a[i][j];
                    link += a[j][i];
                }
            }
        }
        // 두 팀의 점수 차이 (절댓값)
        int val = Math.abs(start-link);
        /*
            백트래킹 부분
            두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
            더 이상의 탐색이 필요없다. 0을 출력하고 System.exit()으로 끝낸다.
        */
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        result = Math.min(val, result);
    }
}
