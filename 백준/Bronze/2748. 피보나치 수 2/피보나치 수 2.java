
import java.util.Scanner;

public class Main {
    public static long[] fibo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N <= 1) {
            System.out.println(N);
            return;
        }

        fibo = new long[N + 1];

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }
        System.out.println(fibo[N]);
    }
}
