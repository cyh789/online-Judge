package algo_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1940_220706 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    //재료의 갯수
        int m = Integer.parseInt(br.readLine());    //값옷을 만드는데 필요한 수
        int[] a = new int[n];   //재료들이 가진 고유한 번호가 담긴 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        //sort
        Arrays.sort(a);

        int i = 0;  //배열a의 시작점
        int j = n-1;  //배열a의 종점
        int count = 0;  //갑옷을 만들 수 있는 개수
        while (i<j) {
            if (a[i] + a[j] == m) {
                count++;
                i++;
                j--;
            }
            if (a[i] + a[j] < m) {
                i++;
            }
            if (a[i] + a[j] > m) {
                j--;
            }
        }

        System.out.println(count);

    }
}
