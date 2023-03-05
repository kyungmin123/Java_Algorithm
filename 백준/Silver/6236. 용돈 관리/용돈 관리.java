import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long biggest = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            biggest = Math.max(biggest, arr[i]);
        }

        long lo = 0;
        long hi = (long)1e9;

        while (lo <= hi) {
            int count = 1;
            long mid = (lo + hi) / 2;
            long curMoney = mid;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    count = -1;
                    break;
                }

                if ((M - count) == (N - i)) {
                    count++;
                    continue;
                }

                if (curMoney < arr[i]) {
                    curMoney = mid - arr[i];
                    count++;
                }
                else {
                    curMoney -= arr[i];
                }
            }
            if (count > M || count == -1) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        System.out.println(lo);
    }
}
