import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
            if(set.contains(a[i])) {
                ans++;
                set.remove(a[i]);
            } else {
                set.add(a[i]);
            }
        }
        System.out.println(ans);
    }
}
