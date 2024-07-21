import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        long[] A = new long[N];
        long[] C = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
            C[i] = scanner.nextLong();
        }


        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(C[i])) {
                if (map.get(C[i]) > A[i]) map.replace(C[i], A[i]);
            } else {
                map.put(C[i], A[i]);
            }
        }

        /* output */
        long max = Long.MIN_VALUE;
        for (Map.Entry<Long, Long> e : map.entrySet()) {
            max = Math.max(e.getValue(), max);
        }

        System.out.println(max);
    }

}
