
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] step = new long[N];

        for (int i = 0; i < N; i++) {
            step[i] = sc.nextInt();
        }

        long[] dp = new long[N];
        dp[0] = step[0];

        if (N > 1) {
            dp[1] = step[0] + step[1];
        }

        if (N > 2) {
            dp[2] = Math.max(step[0] + step[2], step[1] + step[2]);
        }

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + step[i], step[i] + step[i - 1] + dp[i - 3]);
        }

        System.out.println(dp[N - 1]);
    }
}
