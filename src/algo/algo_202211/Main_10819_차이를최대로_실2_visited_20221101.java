package algo.algo_202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로_실2_visited_20221101 {

    private static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[] visited = new boolean[n];
        int depth = 0;
        max = 0;
        int[] output = new int[n];
        int r = arr.length;
        perm(arr, depth, n, r, visited, output);

        System.out.println(max);
    }

    private static void perm(int[] arr, int depth, int n, int r, boolean[] visited, int[] output) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < output.length - 1; i++) {
                sum += Math.abs(output[i] - output[i + 1]);
            }
            if (max < sum) max = sum;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, depth + 1, n, r, visited, output);
                visited[i] = false;
            }
        }
    }
}
