package algo.algo_202211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로_swap_20221109 {

    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int r = n;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());;
        }

        max = Integer.MIN_VALUE;

        perm(arr, n, r, 0);

        System.out.println(max);
    }

    private static void perm(int[] arr, int n, int r, int depth) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < arr.length-1; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            if (max < sum) max = sum;
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, n, r, depth + 1);
            swap(arr, i, depth);
        }
    }

    private static void swap(int[] arr, int i, int depth) {
        int temp = arr[i];
        arr[i] = arr[depth];
        arr[depth] = temp;
    }

}
























