import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int lo = 0;
        int hi = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hi = Math.max(hi, arr[i]);
        }

        int budget = Integer.parseInt(br.readLine());

        while (lo <= hi) {
            long sum = 0;
            int mid = (lo + hi) / 2;

            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += mid;
                }
                else {
                    sum += arr[i];
                }
            }
            if (sum <= budget) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        System.out.println(hi);
    }
}
