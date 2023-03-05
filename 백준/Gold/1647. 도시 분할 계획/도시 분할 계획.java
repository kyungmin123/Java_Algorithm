import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


class Edge {
    public int st;
    public int ed;
    public int cost;

    public Edge (int st, int ed, int cost) {
        this.st = st;
        this.ed = ed;
        this.cost = cost;
    }
}
public class Main {
    private static int[] P;

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
        int answer = 0;
        int sub = 0;
        P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            P[i] = i;
        }
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int cost = sc.nextInt();

            edges.add(new Edge(st, ed, cost));
        }

        edges.sort((o1, o2) -> o1.cost - o2.cost);

        for (int i = 0; i < M; i++) {
            Edge edge = edges.get(i);

            if (Find(edge.st) != Find(edge.ed)) {
                Union(edge.st, edge.ed);
                answer += edge.cost;
                sub = edge.cost;
            }
        }

        System.out.println(answer - sub);
    }
}
