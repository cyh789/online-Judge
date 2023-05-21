package algo.algo_202210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10974_모든순열_20221021 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int r = n;
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        boolean[] visited = new boolean[n];
        int[] output = new int[n];
        perm(arr, visited, output, 0, n, r);
    }

    private static void perm(int[] arr, boolean[] visited, int[] output, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < n; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, visited, output, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}


















