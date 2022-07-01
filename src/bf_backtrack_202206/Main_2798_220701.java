package bf_backtrack_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_220701 {

    private static int result;
    private static boolean[] visit;
    private static int n;
    private static int m;
    private static int[] a;
    private static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        answer = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[n];
        result = 0;

        dfs_2798_22070(0);
        System.out.println(result);
    }

    private static void dfs_2798_22070(int depth) {
        if (depth==3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += answer[i];
            }
            if (sum <= m) {
                result = Math.max(result, sum);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answer[depth] = a[i];
                dfs_2798_22070(depth + 1);
                visit[i] = false;
            }
        }
    }
}
