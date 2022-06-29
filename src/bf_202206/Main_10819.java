package bf_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819 {

    private static boolean[] visit;
    private static int[] A;
    private static int N;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        A = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    // dep : 깊이. prev : 이전 값을 넣는 변수, sum : 총 합계
    private static void dfs(int depth, int prev, int sum) {
        if (depth == N) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, A[i], depth==0 ? 0 : sum + Math.abs(A[i] - prev));
                visit[i] = false;
            }
        }
    }

}
