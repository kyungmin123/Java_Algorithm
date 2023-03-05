import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        if (X == Y) {
            System.out.println(-1);
            return;
        }

        long rate = Y * 100 / X;
        long lo = 1;
        long hi = (long)1e9;
        long result = -1;

        while(lo <= hi) {
            long mid = (lo + hi)  / 2;
            long curRate = (Y + mid) * 100 / (X + mid);

            if (curRate > rate) {
                hi = mid - 1;
                result = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        System.out.println(result);
    }
}
