package algo.algo_202206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1940_220706_2_map으로구현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    //재료의 갯수
        int m = Integer.parseInt(br.readLine());    //값옷을 만드는데 필요한 수
        int[] a = new int[n];   //재료들이 가진 고유한 번호가 담긴 배열
        //재료들이 가진 고유한 번호가 담긴 collection
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            map.put(a[i], false);
        }

        int count = 0;  //갑옷을 만들 수 있는 개수
        for (int i = 0; i < n; i++) {
            map.put(a[i], true);
            if (map.containsKey(m - a[i])) {
                if (!map.get(m - a[i])) {
                    count++;
                    map.put(m - a[i], true);
                    map.put(a[i], true);
                }
            }
        }

        System.out.println(count);
    }
}
