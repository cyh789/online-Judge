package bf_backtrack_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798 {
    static int[] arr;
    static int n;
    static int m;
    static boolean visit[];
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int depth, int sum) {
        if(depth == 3){
            if(sum <= m){
                max = Math.max(max, sum);
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(depth + 1, sum + arr[i]);
                visit[i] = false;
            }
        }
    }
}
