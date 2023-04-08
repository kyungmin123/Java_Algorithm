
import java.util.Scanner;

public class Main {
    private int N;
    private int M;
    private static long[] nums;
    private static Section[] sections;
    private static long[] minSegment;
    private static long[] maxSegment;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();

        int height = (int) Math.ceil(Math.log(N) / Math.log(2));
        int size = (int) Math.pow(2, height + 1);
        nums = new long[N];
        sections = new Section[M];
        minSegment = new long[size];
        maxSegment = new long[size];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextLong();
        }

        for (int i = 0; i < M; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            sections[i] = new Section(left, right);
        }

        initMax(1, 0, nums.length - 1);
        initMin(1, 0, nums.length - 1);

        for (int i = 0; i < sections.length; i++) {
            long min = getMin(1, sections[i].left - 1, sections[i].right - 1, 0, nums.length - 1);
            long max = getMax(1, sections[i].left - 1, sections[i].right - 1, 0, nums.length - 1);

            sb.append(min + " " + max).append("\n");
        }

        System.out.println(sb);
    }

    private static long initMax(int node, int start, int end) {
        if (start == end) return maxSegment[node] = nums[start];

        int mid = (start + end) / 2;

        long leftNode = initMax(node * 2, start, mid);
        long rightNode = initMax(node * 2 + 1, mid + 1, end);

        maxSegment[node] = Math.max(leftNode, rightNode);
        return maxSegment[node];
    }

    private static long getMax(int node, int left, int right, int start, int end) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return maxSegment[node];

        int mid = (start + end) / 2;

        long leftNode = getMax(node * 2, left, right, start, mid);
        long rightNode = getMax(node * 2 + 1, left, right, mid + 1, end);

        return Math.max(leftNode, rightNode);
    }

    private static long initMin(int node, int start, int end) {
        if (start == end) return minSegment[node] = nums[start];

        int mid = (start + end) / 2;

        long leftNode = initMin(node * 2, start, mid);
        long rightNode = initMin(node * 2 + 1, mid + 1, end);

        minSegment[node] = Math.min(leftNode, rightNode);
        return minSegment[node];
    }

    private static long getMin(int node, int left, int right, int start, int end) {
        if (left > end || right < start) return 1000000001;
        if (left <= start && end <= right) return minSegment[node];

        int mid = (start + end) / 2;

        long leftNode = getMin(node * 2, left, right, start, mid);
        long rightNode = getMin(node * 2 + 1, left, right, mid + 1, end);

        return Math.min(leftNode, rightNode);
    }

    private static class Section {
        private int left;
        private int right;

        public Section(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}
