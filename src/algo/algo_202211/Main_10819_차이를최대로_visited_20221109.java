package algo.algo_202211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로_visited_20221109 {

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

        max = Integer.MIN_VALUE;
        boolean[] visited = new boolean[n];
        int[] output = new int[n];

        perm(arr, n, r, 0, visited, output);

        System.out.println(max);
    }

    private static void perm(int[] arr, int n, int r, int depth, boolean[] visited, int[] output) {
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
                perm(arr, n, r, depth + 1, visited, output);
                visited[i] = false;
            }
        }
    }
}





























