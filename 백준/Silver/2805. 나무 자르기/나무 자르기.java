import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Integer> trees = new ArrayList<>();
    private static long binSearch(long height) {
        long sum = 0;
        for (var tree : trees) {
            if (tree > height){
                sum += tree - height;
            }
        }
        return sum;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[]{};
        String[] temp = new String[]{};


        arr = br.readLine().split(" ");
        temp = br.readLine().split(" ");
        for (var v : temp){
            trees.add(Integer.parseInt(v));
        }

        int n = Integer.parseInt(arr[0]);
        int len = Integer.parseInt(arr[1]);

        long start = 0;
        long end = Collections.max(trees);
        long ans = 0;
        long mid = (start + end) / 2;

        while (ans != mid) {
            ans = binSearch(mid);
            if (ans >= len) {
                ans = mid;
                start = mid;
            }
            else {
                end = mid;
            }
            mid = (start + end) / 2;
        }
        System.out.println(ans);
    }
}
