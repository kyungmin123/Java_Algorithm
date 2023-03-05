import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static long M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        long [] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long least = (long)1e15;

        for (int i = 0; i < N; i++) {
            long result = binSearch(arr[i], i + 1, arr);
            least = Long.min((result == -1) ? (long)1e15 : result, least);
        }
        System.out.println(least);
    }

    public static long binSearch(long num, int pos, long[] arr) {
        int lo = pos;
        int hi = arr.length - 1;
        long result = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            long sub = arr[mid] - num;
            if (sub >= M) {
                hi = mid - 1;
                result = sub;
            }
            else {
                lo = mid + 1;
            }
        }

        return result;
    }
}
