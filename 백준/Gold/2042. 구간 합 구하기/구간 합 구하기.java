
import java.util.Scanner;

public class Main {
    private static long[] nums;
    private static long[] segmentTree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        nums = new long[N];
        int ext = (int) Math.ceil(Math.log(N)/ Math.log(2)) + 1;
        segmentTree = new long [(int) Math.pow(2, ext)];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextLong();
        }

        init(1, 0, nums.length - 1);

        for (int i = 0; i < M + K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();

            if (a == 1) {
                long diff = c - nums[b - 1];
                nums[b - 1] = c;
                update(1, 0, nums.length - 1, b - 1, diff);
            }

            else if (a == 2) {
                long result = getSum(1, b - 1, (int) c - 1, 0, nums.length - 1);
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static long init(int node, int start, int end) {
        if (start == end) return segmentTree[node] = nums[start];
        int mid = (start + end) / 2;

        long left = init(node * 2, start, mid);
        long right = init(node * 2 + 1, mid + 1, end);

        segmentTree[node] = left + right;
        return segmentTree[node];
    }

    private static long getSum(int node, int left, int right, int start, int end) {
        if (start > right || left > end) return 0;
        if (end <= right && start >= left) return segmentTree[node];

        int mid = (start + end) / 2;

        long leftSum = getSum(node * 2, left, right, start, mid);
        long rightSum = getSum(node * 2 + 1, left, right,mid + 1, end);

        return leftSum + rightSum;
    }

    private static void update(int node, int start, int end, int index, long diff) {
        if (index < start || index > end) return;

        segmentTree[node] += diff;
        if (start == end) return;

        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, diff);
        update(node * 2 + 1, mid + 1, end, index, diff);
    }
}
