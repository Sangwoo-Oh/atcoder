import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        int[] c = new int[m];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i=0; i<m; i++) {
            b[i] = scanner.nextInt();
            c[i] = b[i];
        }

        Arrays.sort(b);
        // おいしさを前から順番にスタックに格納
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<m; i++) {
            stack.push(b[i]);
        }

        HashMap<Integer, Integer> sushiToNum = new HashMap<>();
        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                int sushi = stack.pop();
                sushiToNum.put(sushi, i+1);
            }
        }


        for (int i=0; i<m; i++) {
            if (sushiToNum.containsKey(c[i])) {
                System.out.println(sushiToNum.get(c[i]));
            } else {
                System.out.println(-1);
            }
        }
    }
}
