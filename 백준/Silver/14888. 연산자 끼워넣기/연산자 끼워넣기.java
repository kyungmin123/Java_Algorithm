

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static int[] operand;
    private static int[] operator;
    private static int N;
    private static int maxValue = -987654321;
    private static int minValue = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        operand = new int[N];
        operator = new int[4];

        for (int i = 0 ; i < N; i++) {
            operand[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        dfs(operand[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    public static void dfs(int num, int index) {
        if (index == N) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }

        for (int i = 0 ; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i] -= 1;

                switch(i) {
                    case 0:
                        dfs(num + operand[index], index+ 1);
                        break;
                    case 1:
                        dfs(num - operand[index], index + 1);
                        break;
                    case 2:
                        dfs(num * operand[index], index + 1);
                        break;
                    case 3:
                        dfs(num / operand[index], index + 1);
                        break;
                }

                operator[i] += 1;
            }
        }
    }
}
