
import java.util.*;

public class Main {
    public static int N;
    public static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
    public static int[][] Map;
    public static Map<Integer, Set<Integer>> preferences;
    public static int[] students;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Map = new int[N + 1][N + 1];
        preferences = new HashMap<>();
        students = new int[(int) Math.pow(N, 2) + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0 ; j <= N; j++) {
                Map[i][j] = 0;
            }
        }

        for (int i = 1; i <= Math.pow(N, 2); i++) {
            int student = sc.nextInt();
            students[i] = student;
            preferences.put(student, new HashSet<>());
            for (int j = 0 ; j < 4; j++) {
                preferences.get(student).add(sc.nextInt());
            }
        }

        for (int i = 1; i < students.length; i++) {
            Seat seat = findSeat(students[i]);
            Map[seat.x][seat.y] = students[i];
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int satisfied = getPreferences(i, j, Map[i][j]);
                int score = (int) Math.pow(10, satisfied - 1);
                ans += score;
            }
        }

        System.out.println(ans);
    }

    public static Seat findSeat(int student) {
        Seat seat = null;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (Map[i][j] > 0) {
                    continue;
                }

                Seat cur = new Seat(i, j, getPreferences(i, j, student), getEmptySeats(i, j));

                if (seat == null) {
                    seat = cur;
                    continue;
                }

                if (seat.compareTo(cur) > 0) {
                    seat = cur;
                }
            }
        }
        return seat;
    }

    public static int getEmptySeats(int x, int y) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                if (Map[nx][ny] == 0) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public static int getPreferences(int x, int y, int student) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                if (Map[nx][ny] != 0 && preferences.get(student).contains(Map[nx][ny])) {
                    count += 1;
                }
            }
        }
        return count;
    }

    static class Seat implements Comparable<Seat> {
        public int x;
        public int y;
        public int students;
        public int emptySeat;

        public Seat(int x, int y, int students, int emptySeat) {
            this.x = x;
            this.y = y;
            this.students = students;
            this.emptySeat = emptySeat;
        }

        @Override
        public int compareTo(Seat other) {
            if (this.students != other.students) {
                return -(this.students - other.students);
            }

            if (this.emptySeat != other.emptySeat) {
                return -(this.emptySeat - other.emptySeat);
            }

            if (this.x != other.x) {
                return this.x - other.x;
            }

            return this.y - other.y;
        }
    }
}
