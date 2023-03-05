import java.util.Scanner;

public class Main {
    public static int[] P;

    public static int Find(int a) {
        if (P[a] == a) return a;
        else return P[a] = Find(P[a]);
    }
    public static void Union(int a, int b) {
        a = Find(a);
        b = Find(b);
        P[b] = a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        P = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            P[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int cal = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (cal == 0) {
                Union(a, b);
                continue;
            }

            if (Find(a) == Find(b)) {
                sb.append("YES").append("\n");
            }
            else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
