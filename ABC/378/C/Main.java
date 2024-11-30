import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (map.containsKey(a[i])) {
                b[i] = map.get(a[i]);
                map.put(a[i], i+1);
            } else {
                b[i] = -1;
                map.put(a[i], i+1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(b[i]);
        }
    }
}
