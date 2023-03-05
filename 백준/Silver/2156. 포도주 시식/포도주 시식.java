
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] wine = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            int curr = sc.nextInt();
            wine[i] = curr;
        }

        dp[0] = wine[0];

        if (N > 1){
            dp[1] = wine[1] + wine[0];
        }

        if (N > 2) {
            int M = Math.max(wine[0] + wine[2], wine[1] + wine[2]);
            dp[2] = Math.max(M, dp[1]);
        }

        for (int i = 3; i < N; i++) {
            int M = wine[i] + Math.max(dp[i - 3] + wine[i - 1], dp[i - 2]);
            dp[i] = Math.max(M, dp[i - 1]);
        }
        System.out.println(dp[N - 1]);
    }
}
