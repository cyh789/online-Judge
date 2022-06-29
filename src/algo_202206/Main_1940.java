package algo_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1940 {
    public static void main(String[] args) throws Exception {

        // 1. 배열의 개수인 N이 15000이므로 O(N^2)의 경우 시간초과
        // 2. 투포인트 정렬을 사용하여 O(NlogN)으로 풀이

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 오른차순 정렬
        Arrays.sort(A);

        // 배열 start = 0, end = N-1
        int i = 0;
        int j = N-1;
        int count = 0;
        while (i<j) {
            if (A[i] + A[j] == M) {
                count++;
                i++;
                j--;
            }
            if (A[i] + A[j] < M) {
                i++;
            }
            if (A[i] + A[j] > M) {
                j--;
            }
        }

        System.out.println(count);
    }
}