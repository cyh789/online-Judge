package bf_backtrack_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_220701_2_이게정답 {

    private static int[][] a;
    private static int n;
    private static int result;
    private static boolean[] visit;

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

        visit = new boolean[n];
        result = Integer.MAX_VALUE;

        dfs_14889_220701_2(0,0);
        System.out.println(result);
    }

    private static void dfs_14889_220701_2(int depth, int start) {
        if (depth==n/2) {
            diff_14889_220701_2();
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs_14889_220701_2(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }

    private static void diff_14889_220701_2() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (visit[i]==true && visit[j]==true) {
                    start += a[i][j];
                    start += a[j][i];
                }
                else if (visit[i]==false && visit[j]==false) {
                    link += a[i][j];
                    link += a[j][i];
                }
            }
        }

        int val = Math.abs(start-link);
        if (val==0) {
            System.out.println(val);
            System.exit(0);
        }

        result = Math.min(result, val);
    }
}
