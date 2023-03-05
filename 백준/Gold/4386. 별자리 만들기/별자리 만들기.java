import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Point {
    public double x;
    public double y;
    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Dist {
    public int p1;
    public int p2;
    public double distance;
    public Dist (int p1, int p2, double distance) {
        this.p1 = p1;
        this.p2 = p2;
        this.distance = distance;
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

        int n = sc.nextInt();
        P = new int[n];
        for (int i = 0; i < n; i++) {
            P[i] = i;
        }
        Point[] dist = new Point[n];

        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            dist[i] = new Point(x, y);
        }

        ArrayList<Dist> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double d = Math.sqrt(Math.pow(dist[i].x - dist[j].x, 2) + Math.pow(dist[i].y - dist[j].y, 2));
                path.add(new Dist(i, j, d));
            }
        }

        path.sort(new Comparator<Dist>() {
            @Override
            public int compare(Dist o1, Dist o2) {
                return Double.compare(o1.distance, o2.distance);
            }
        });

        double answer = 0;
        for (var edge : path) {
            if (Find(edge.p1) != Find(edge.p2)) {
                answer += edge.distance;
                Union(edge.p1, edge.p2);
            }
        }

        System.out.println(String.format("%.2f", answer));
    }
}
