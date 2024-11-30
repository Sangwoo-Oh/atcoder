import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }

        int max = 0;

        HashSet<Integer> set = new HashSet<>();
        // starting from 0
        int right = 0;
        for (int left = 0; left < n; left += 2) {
            if (right < left) right = left;
            while (right < n-1 && a[right] == a[right+1] && !set.contains(a[right])) {
                set.add(a[right]);
                right += 2;
            }
            max = Math.max(max, right - left);
            set.remove(a[left]);
        }

        // starting from 1
        set = new HashSet<>();
        right = 1;
        for (int left = 1; left < n; left += 2) {
            if (right < left) right = left;
            while (right < n-1 && a[right] == a[right+1] && !set.contains(a[right])) {
                set.add(a[right]);
                right += 2;
            }
            max = Math.max(max, right - left);
            set.remove(a[left]);
        }

        System.out.println(max);
    }
}
