
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        int N = sc.nextInt();
        int[][] RGB = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = RGB[0][0];
        dp[0][1] = RGB[0][1];
        dp[0][2] = RGB[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(RGB[i][0] + dp[i - 1][1], RGB[i][0] + dp[i - 1][2]);
            dp[i][1] = Math.min(RGB[i][1] + dp[i - 1][0], RGB[i][1] + dp[i - 1][2]);
            dp[i][2] = Math.min(RGB[i][2] + dp[i - 1][0], RGB[i][2] + dp[i - 1][1]);
        }

        System.out.println(getMin(dp[N - 1][0], dp[N - 1][1], dp[N - 1][2]));
    }

    static int getMin(int a, int b, int c) {
        int m = Math.min(a, b);
        m = Math.min(m, c);

        return m;
    }
}
