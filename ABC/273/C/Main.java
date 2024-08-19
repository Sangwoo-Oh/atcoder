import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
            set.add(a[i]);
        }
        ArrayList<Integer> b = new ArrayList<>(set);
        Collections.sort(b);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<b.size(); i++) {
            map.put(b.get(i), b.size()-i-1);
        }

        HashMap<Integer, Integer> occurrence = new HashMap<>();
        for (int x : a) {
            occurrence.put(map.get(x), occurrence.getOrDefault(map.get(x), 0)+1);
        }

        for (int i=0; i<n; i++) {
            System.out.println(occurrence.getOrDefault(i,0));
        }
    }
}
