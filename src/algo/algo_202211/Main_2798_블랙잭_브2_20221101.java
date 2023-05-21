package algo.algo_202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_블랙잭_브2_20221101 {

    private static int max;
    private static int m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());;
        }

        boolean[] visited = new boolean[N];
        max = 0;
        int depth = 0;
        int r = 3;
        int[] output = new int[N];
        perm(arr, depth, N, r, visited, output);

        System.out.println(max);
    }

    private static void perm(int[] arr, int depth, int n, int r, boolean[] visited, int[] output) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += output[i];
            }
            if (max < sum && sum <= m) max = sum;
            return;
        }

        for (int i = depth; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, depth + 1, n, r, visited, output);
                visited[i] = false;
            }
        }
    }
}
