package bf_backtrack_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_220630 {
    static int[] a;
    static int[] answer;
    static int n;
    static int m;
    static boolean visit[];
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[n];
        answer = new int[n];
        dfs_2798_220630(0);

        System.out.println(result);
    }

    private static void dfs_2798_220630(int depth) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += answer[i];
            }
            if (sum > m) {
                return;
            }
            result = Math.max(sum, result);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answer[depth] = a[i];
                dfs_2798_220630(depth + 1);
                visit[i] = false;
            }
        }

    }
}
