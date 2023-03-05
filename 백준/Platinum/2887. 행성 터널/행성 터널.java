
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Distance {
    public int p1;
    public int p2;
    public long distance;
    public Distance(int p1, int p2, long distance) {
        this.p1 = p1;
        this.p2 = p2;
        this.distance = distance;
    }
}

class Point {
    public long x;
    public long y;
    public long z;
    public int index;
    public Point(int index, long x, long y, long z) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    private static int[] P;
    public static int Find (int a) {
        if (P[a] == a) return a;
        else return P[a] = Find(P[a]);
    }
    public static void Union (int a, int b) {
        a = Find(a);
        b = Find(b);
        P[b] = a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        P = new int[N + 1];
        ArrayList<Point> pt = new ArrayList<>();
        ArrayList<Distance> distances = new ArrayList<>();


        for (int i = 1; i <= N; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long z = sc.nextLong();

            pt.add(new Point(i, x, y, z));
            P[i] = i;
        }

        pt.sort((p1, p2) -> Double.compare(p1.x, p2.x));

        for (int i = 1; i < N; i++) {
            var prePoint = pt.get(i - 1);
            var point = pt.get(i);
            distances.add(new Distance(prePoint.index, point.index, Math.abs(point.x - prePoint.x)));
        }

        pt.sort((p1, p2) -> Double.compare(p1.y, p2.y));

        for (int i = 1; i < N; i++) {
            var prePoint = pt.get(i - 1);
            var point = pt.get(i);
            distances.add(new Distance(prePoint.index, point.index, Math.abs(point.y - prePoint.y)));
        }

        pt.sort((p1, p2) -> Double.compare(p1.z, p2.z));

        for (int i = 1; i < N; i++) {
            var prePoint = pt.get(i - 1);
            var point = pt.get(i);
            distances.add(new Distance(prePoint.index, point.index, Math.abs(point.z - prePoint.z)));
        }

        distances.sort((d1, d2) -> Long.compare(d1.distance, d2.distance));

        int answer = 0;
        for (var d : distances) {
            if (Find(d.p1) != Find(d.p2)) {
                Union(d.p1, d.p2);
                answer += d.distance;
            }
        }
        System.out.println(answer);
    }
}
