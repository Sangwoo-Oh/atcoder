import java.util.*;
import java.lang.*;

public class Main {
    static int n, d;
    static int[] x;
    static int[] y;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        n = scanner.nextInt();
        d = scanner.nextInt();

        x = new int[n];
        y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] ans = new boolean[n];
        ans[0] = true;
        q.push(0);

        // bfs
        while(!q.isEmpty()) {
            int v = q.pop();
            for (int i = 0; i < n; i++) {
                if (isNear(v,i,d)) {
                    if (ans[i] == true) continue;
                    ans[i] = true;
                    q.push(i);
                }
            }
        }

        /* output */
        for (boolean a : ans) {
            if (a) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    static boolean isNear(int a, int b, int d) {
        int dx = x[a] - x[b];
        int dy = y[a] - y[b];
        return dx*dx + dy*dy <= d*d;
    }


    /* next permutation method */
    static boolean next_permutation(int[] array, int start, int end) {
        if(array == null || start > end || start < 0 || end > array.length) {
            System.out.println("Error: 引数が正しくありません。");
            return false;
        }

        for(int i=end-2; i>=start; i--) {
            if(array[i] < array[i+1]) {
                int j = end - 1;
                while(array[i] >= array[j]) {
                    j--;
                }

			    //swap
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;

                Arrays.sort(array, i+1, end);

                return true;
            }
        }
        return false;
    }
}
