import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

class Pos {
    public long x;
    public long y;

    public Pos (long x, long y) {
        this.x = x;
        this.y = y;
    }
}
class Distance {
    public int n1;
    public int n2;
    public double d;

    public Distance(int n1, int n2, double d) {
        this.n1 = n1;
        this.n2 = n2;
        this.d = d;
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
        double answer = 0;
        Pos[] dist = new Pos[N + 1];
        ArrayList<Distance> weight = new ArrayList<>();
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            P[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            long x = sc.nextInt();
            long y = sc.nextInt();
            dist[i] = new Pos(x, y);
        }

        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            Union(n1, n2);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                weight.add(new Distance(i, j, Math.sqrt(Math.pow(dist[i].x - dist[j].x, 2) + Math.pow(dist[i].y - dist[j].y, 2))));
            }
        }

        weight.sort(new Comparator<Distance>() {
            @Override
            public int compare(Distance o1, Distance o2) {
                return Double.compare(o1.d, o2.d);
            }
        });

        for (var edge : weight) {
            if (Find(edge.n1) != Find(edge.n2)) {
                answer += edge.d;
                Union(edge.n1, edge.n2);
            }
        }

        System.out.println(String.format("%.2f", answer));
    }
}
