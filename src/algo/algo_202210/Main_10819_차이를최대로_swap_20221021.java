package algo.algo_202210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {

    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int depth = 0;
        int r = n;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());;
        }

        max = 0;
        perm(arr, 0, n, r);

        System.out.println(max);
    }

    private static void perm(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(arr[i]-arr[i+1]);
            }
            if (max < sum) max = sum;
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            perm(arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }

    private static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

}
























