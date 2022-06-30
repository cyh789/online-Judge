package bf_backtrack_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_220630_2 {

    private static int n;
    private static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int sum[];
    private static boolean[] visit;

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
        dfs(0,0);
        System.out.println(min);
    }

    private static void dfs(int t, int p) {
        if (p==n/2) {
            diff();
        }
        for (int i = t; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i+1, p+1);
                visit[i] = false;
            }
        }
    }

    private static void diff() {
        int team_start = 0;
        int team_link = 0;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(visit[i] == true && visit[j] == true) {
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                }
                else if(visit[i] == false && visit[j] == false) {
                    team_link += arr[i][j];
                    team_link += arr[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link);

        if(val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(val, min);
    }
}
