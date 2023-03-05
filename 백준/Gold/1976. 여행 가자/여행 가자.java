import java.util.Scanner;

public class Main {
    private static int[][] graph;
    private static int[] P;
    private static int[] path;
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

        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new int[N + 1][N + 1];
        P = new int[N + 1];
        path = new int[M];

        for (int i = 1; i <= N; i++) {
            P[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == 1) {
                    Union(i, j);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            path[i] = Find(sc.nextInt());
        }

        for (int i = 1; i < M; i++) {
            if (path[i] != path[i - 1]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
