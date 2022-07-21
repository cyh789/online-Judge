package algo_202207;

import java.util.Scanner;
import java.util.Stack;

public class Main_1874_220720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.nextLine());
        }

        Stack<Integer> stack = new Stack();
        int num = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (num <= a[i]) {
                while (num <= a[i]) {
                    stack.push(num++);
                    sb.append("+\n");
                }

                stack.pop();
                sb.append("-\n");
            } else {
                int currNum = stack.pop();
                if (currNum > a[i]) {
                    System.out.println("NO");
                    System.exit(0);
                } else {
                    sb.append("-\n");
                }
            }
        }

        System.out.println(sb);
        System.exit(0);
    }
}
