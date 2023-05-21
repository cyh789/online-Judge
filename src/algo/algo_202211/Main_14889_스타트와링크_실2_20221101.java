package algo.algo_202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크_실2_20221101 {

    private static int min;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());;
            }
        }

        boolean[] visited = new boolean[N];
        int depth = 0;
        int r = N/2;
        min = Integer.MAX_VALUE;
        int start = 0;
        perm(arr, depth, N, r, visited, start);

        System.out.println(min);
    }

    private static void perm(int[][] arr, int depth, int n, int r, boolean[] visited, int start) {
        if (depth == r) {
            func(arr, visited);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            perm(arr, depth + 1, n, r, visited, i + 1);
            visited[i] = false;
        }
    }

    private static void func(int[][] arr, boolean[] visited) {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i != j) {
                    if (visited[i] == true && visited[j] == true) {
                        startSum += arr[i][j];
                        startSum += arr[j][i];
                    } else if (visited[i] == false && visited[j] == false) {
                        linkSum += arr[i][j];
                        linkSum += arr[j][i];
                    }
                }
            }
        }

        int val = Math.abs(startSum - linkSum);
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        if (min > val) min = val;
    }
}
