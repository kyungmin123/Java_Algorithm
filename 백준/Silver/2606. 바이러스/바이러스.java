import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] arr = new ArrayList[101];
    public static boolean[] visited = new boolean[101];
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        for (int i = 0; i < 101; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        N = sc.nextInt();
        int edge = sc.nextInt();

        for (int i = 0; i < edge; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        System.out.println(dfs(1));
    }

    public static int dfs(int node) {
        int result = 0;
        visited[node] = true;

        for (int v: arr[node]) {
            if (!visited[v]) {
                result += dfs(v) + 1;
            }
        }


        return result;
    }
}
