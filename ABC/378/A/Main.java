import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int[] a = new int[4];
        for (int i = 0; i < 4; i++) {
            a[i] = scanner.nextInt();
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int res = 0;
        for (int i = 0; i < 4; i++) {
            if (set.contains(a[i])) {
                set.remove(a[i]);
                res++;
            } else {
                set.add(a[i]);
            }
        }
        System.out.println(res);
    }
}
