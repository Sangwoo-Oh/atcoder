import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        Integer[] p = new Integer[n];
        for (int i=0; i<n; i++) p[i] = scanner.nextInt();

        // p[i] > p[i+1] となる最初のポジションを探す
          // 存在しなかったら k = 1番目なので、降順ソートされた状態を出力
        //
        int i=n-2;
        while (i >= 0 && p[i] <= p[i+1]) i--;

        if (i<0) {
            Arrays.sort(p, Collections.reverseOrder());
            for (int x : p) System.out.print(x + " ");
            System.out.println();
        } else {
            int j = i+1;
            for (int k=i+1; k<n; k++) {
                if (p[i] > p[k] && p[j] < p[k]) j = k;
            }

            // swap
            int tmp = p[i];
            p[i] = p[j];
            p[j] = tmp;

            // reverse sort
            Arrays.sort(p, i+1, n, Collections.reverseOrder());

            for (int x : p) System.out.print(x + " ");
            System.out.println();
        }
    }
}
