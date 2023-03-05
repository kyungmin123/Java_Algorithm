import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        ArrayList<String> list = new ArrayList<>();

        for (var item : arr) {
            list.add(item);
        }

        Collections.sort(list);

        int m = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");


        for (var item : arr2) {
            int result = Collections.binarySearch(list, item);
            sb.append((result >= 0) ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}
