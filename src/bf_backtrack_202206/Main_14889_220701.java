package bf_backtrack_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_220701 {

    private static int n;
    private static int[][] arr;
    private static boolean[] visit;
    private static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n];
        result = Integer.MAX_VALUE;

        dfs_14889_220701(0,0);
        System.out.println(result);
    }

    private static void dfs_14889_220701(int depth, int count) {
        if (depth==n/2) {
            diff_14889_220701();
            return;
        }
        for (int i = count; i < n; i++) {
            visit[i] = true;
            dfs_14889_220701(depth + 1, i + 1);
            visit[i] = false;
        }
    }

    private static void diff_14889_220701() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (visit[i]==true && visit[j]==true) {
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else if (visit[i]==false && visit[j]==false) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int val = Math.abs(start-link);
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        result = Math.min(val, result);
    }
}
