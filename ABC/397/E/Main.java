import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int aa: a) {
            map.put(aa, map.getOrDefault(aa, 0)+1);
        }

        // int sizeA = 0;
        int sizeB = map.size();
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n-1; i++) {
            set.add(a[i]);
            map.put(a[i], get(a[i])-1);
            if (map.get(a[i]) == 0) {
                sizeB--;
            }
            max = Math.max(max, set.size() + sizeB);
        }

        System.out.println(max);
    }
}
