import java.util.*;

public class Main {
    public static int[][] arr;
    public static boolean[][] visited;
    public static int N;

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
        N = sc.nextInt();

        arr = new int[N][N];
        visited = new boolean[N][N];

        ArrayList<Integer> result = new ArrayList();

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    result.add(bfs(i, j));
                }
            }
        }

        Collections.sort(result);

        sb.append(result.size()).append("\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.print(sb);
    }

    public static int bfs(int m, int n) {
        Queue<Node> q = new LinkedList();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int count = 1;
        visited[m][n] = true;
        q.add(new Node(m, n));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (!visited[nx][ny] && arr[nx][ny] == 1) {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
