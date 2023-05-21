package algo.algo_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제목 : 구간 합 구하기 5
 * 난이도 : 백준 실버1
 * 링크 : https://www.acmicpc.net/problem/11660
 *
 *
 *
 * 풀이
 * 1. N이 1024이고, 부분합을 M(100,000) 번 구해야한다.
 * 단순하게 그때 그때 부분합을 구하게 되면 N^2(1024*1024) * M(10만)으로 시간초과가 예상된다.
 *
 * 2. 누적 합 공식 이용
 * 시간복잡도, N^2번 입력 받을떄 누적합을 구하므로 O(N^2) - N은 1,024로 양호함
 * 공간복잡도, 2차원 배열로 N이 크지 않으므로(1024^2) 특별히 고려하지 않음.
 * * D[i][j]의 값을 채우는 구간 합 공식
 * D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
 */
public class Main_11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //배열의 크기
        int M = Integer.parseInt(st.nextToken());   //질의 갯수

        //원본 배열 저장 - 0 사용안함
        int A[][] = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //합 배열 저장
        int D[][] = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
            }
        }

        //질의 응답
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = D[x2][y2] - D[x1 -1][y2] - D[x2][y1 -1] + D[x1 -1][y1 -1];
            System.out.println(result);
        }
    }
}
