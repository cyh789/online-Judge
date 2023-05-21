package algo.algo_202210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로_visited_20221021 {

    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int r = n;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[n];
        int[] output = new int[n];
        max = 0;
        perm(arr, visited, output, 0, n, r);

        System.out.println(max);
    }

    private static void perm(int[] arr, boolean[] visited, int[] output, int depth, int n, int r) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(output[i] - output[i + 1]);
            }
            if (max < sum) max = sum;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, visited, output, depth+1, n, r);
                visited[i] = false;
            }
        }
    }
}





























