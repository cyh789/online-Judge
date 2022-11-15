package algo.algo_202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_블랙잭_브2_20221109 {

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

        max = Integer.MIN_VALUE;
        boolean[] visited = new boolean[N];
        int[] output = new int[N];
        perm(N, 3, arr, 0, visited, output);

        System.out.println(max);
    }

    private static void perm(int n, int r, int[] arr, int depth, boolean[] visited, int[] output) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < output.length; i++) {
                sum += output[i];
            }
            if (max < sum && sum <= m) max = sum;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(n, r, arr, depth + 1, visited, output);
                visited[i] = false;
            }
        }
    }
}
































