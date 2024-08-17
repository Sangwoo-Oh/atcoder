import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        HashMap<Integer, Integer> numToLevel = new HashMap<>();
        numToLevel.put(a[0], 0);
        for (int i = 0; i < n; i++) {
            int prev = numToLevel.get(a[i]);
            numToLevel.put((i+1)*2, prev + 1);
            numToLevel.put((i+1)*2+1, prev + 1);
        }

        for (int i = 1; i <= n*2+1; i++) {
            System.out.println(numToLevel.get(i));
        }
    }
}
