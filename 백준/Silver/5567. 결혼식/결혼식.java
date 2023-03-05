
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer>[] arr = new ArrayList[501];
    public static boolean[] visited = new boolean[501];
    public static int[] dist = new int[501];
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        int edge = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        while(edge-- > 0){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        int result = bfs(1);

        System.out.println(result);
    }

    public static int bfs(int n) {
        Queue<Integer> q = new LinkedList();
        int count = 0;

        visited[n] = true;
        dist[n] = 0;
        q.add(n);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : arr[node]) {
                if (!visited[next] && 0 <= dist[node] && dist[node] < 2) {
                    q.offer(next);
                    dist[next] = dist[node] + 1;
                    visited[next] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
