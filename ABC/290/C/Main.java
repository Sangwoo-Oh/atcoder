import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int consecutive = 0;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) == consecutive) {
                consecutive++;
            }
        }
        int ans = Math.min(consecutive, k);

        System.out.println(ans);
    }
}
