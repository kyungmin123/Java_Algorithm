import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static boolean[][] visited;
    public static int w;
    public static int h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        dfs(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    public static void dfs(int m, int n) {
        int[] dx = {-1, 1, 0};
        int[] dy = {0, -1, 1};

        visited[m][n] = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int ny = m + dy[i];
                int nx = n + dx[j];

                if (0 <= nx && nx < arr[0].length && 0 <= ny && ny < arr.length) {
                    if (!visited[ny][nx] && arr[ny][nx] == 1) {
                        dfs(ny, nx);
                    }
                }
            }
        }
    }
}