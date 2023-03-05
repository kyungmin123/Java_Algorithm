import java.util.*;

public class Main {
    public static int[][] arr;
    public static boolean[][] visited;
    public static int W;
    public static int H;

    static class Node{
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        while (T-- > 0) {
            W = sc.nextInt();
            H = sc.nextInt();
            int K = sc.nextInt();

            arr = new int[H][W];
            visited = new boolean[H][W];

            while (K-- > 0) {
                int X = sc.nextInt();
                int Y = sc.nextInt();

                arr[Y][X] = 1;
            }

            int result = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        bfs(j, i);
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");

        }
        System.out.print(sb);
    }

    public static void bfs(int m, int n) {
        Queue<Node> q = new LinkedList();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[n][m] = true;
        q.add(new Node(m, n));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (0 <= nx && nx < W && 0 <= ny && ny < H) {
                    if (!visited[ny][nx] && arr[ny][nx] == 1) {
                        q.offer(new Node(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
