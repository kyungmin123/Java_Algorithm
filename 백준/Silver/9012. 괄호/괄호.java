import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Map<String, String> hashmap = new HashMap<String, String>();
        hashmap.put(")", "(");

        int n = Integer.valueOf(sc.nextLine());
        while (n-- > 0) {
            String state = "YES";
            Stack<String> stack = new Stack<>();
            String line = sc.nextLine();

            for (int i = 0; i < line.length(); i++) {
                String curr = String.valueOf(line.charAt(i));
                if (hashmap.get(curr) == null) {
                    stack.push(curr);
                }
                else {
                    if (stack.empty() || hashmap.get(curr) == stack.pop()){
                        state = "NO";
                        break;
                    }
                }
            }

            if (!stack.empty()) {
                state = "NO";
            }

            sb.append(state).append("\n");
        }
        System.out.println(sb);
    }
}
