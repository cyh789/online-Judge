package bf_backtrack_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_220630 {

    private static int[] answer;
    private static int result = 0;
    private static int n;
    private static int m;
    private static boolean[] visit;
    private static int[] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[n];
        answer = new int[n];
        dfs_10819_220630(0);

        System.out.println(result);
    }

    private static void dfs_10819_220630(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(answer[i] - answer[i+1]);
            }
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answer[depth] = a[i];
                dfs_10819_220630(depth + 1);
                visit[i] = false;
            }
        }
    }
}
