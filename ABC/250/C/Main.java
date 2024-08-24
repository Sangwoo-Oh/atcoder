import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = i+1;
        Map<Integer, Integer> itemToPos = new HashMap<>();
        for (int i = 0; i < n; i++) itemToPos.put(i+1, i);

        int q = scanner.nextInt();

        for (int i=0; i<q; i++) {
            int x = scanner.nextInt();
            int j = itemToPos.get(x);

            if (j != n-1) {
                int tmp = a[j];
                a[j] = a[j+1];
                a[j+1] = tmp;
                itemToPos.put(x, j+1);
                itemToPos.put(a[j], j);
            } else {
                int tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
                itemToPos.put(x, j-1);
                itemToPos.put(a[j], j);
            }
        }

        for (int i=0; i<n; i++) {
            System.out.print(a[i]);
            if (i != n-1) System.out.print(" ");
        }
        System.out.println();
    }
}
