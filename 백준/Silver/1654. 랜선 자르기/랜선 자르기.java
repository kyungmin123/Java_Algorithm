import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long goal = Long.parseLong(st.nextToken());
        long[] arr = new long[n];
        long lo = 0;
        long hi = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            hi = Math.max(hi, arr[i]);
        }

        while (lo <= hi) {
            long mid = (lo + hi + 1) / 2;
            long count = 0;

            for (int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }

            if (count >= goal) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        System.out.println(hi);
    }
}
