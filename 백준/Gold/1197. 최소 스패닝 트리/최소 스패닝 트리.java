import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Edge{
    int st, ed, cost;
    public Edge (int st, int ed, int cost) {
        this.st = st;
        this.ed = ed;
        this.cost = cost;
    }
}
public class Main {
    private static int V;
    private static int E;
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

        V = sc.nextInt();
        E = sc.nextInt();
        P = new int[V + 1];
        ArrayList<Edge> edges = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < E; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int cost = sc.nextInt();

            edges.add(new Edge(st, ed, cost));
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        for (int i = 1; i <= V; i++) {
            P[i] = i;
        }

        for (int i = 0; i < E; i++) {
            Edge edge = edges.get(i);

            if (Find(edge.st) != Find(edge.ed)) {
                Union(edge.st, edge.ed);
                answer += edge.cost;
            }
        }

        System.out.println(answer);
    }
}
