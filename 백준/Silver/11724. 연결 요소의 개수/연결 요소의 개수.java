import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer>[] arr = new ArrayList[1001];
    public static boolean[] visited = new boolean[1001];
    public static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));

        for (int i = 0; i < 1001; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int u) {
        for (int num: arr[u]) {
            if (visited[num]) {
                continue;
            }
            visited[num] = true;
            dfs(num);
        }
    }
}
