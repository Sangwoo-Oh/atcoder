import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int q = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<q; i++) {
            int query = scanner.nextInt();
            if (query==1) {
                int x = scanner.nextInt();
                map.put(x, map.getOrDefault(x, 0)+1);
            } else if (query==2) {
                int x = scanner.nextInt();
                map.put(x, map.get(x)-1);
                if (map.get(x)==0) {
                    map.remove(x);
                }
            } else {
                System.out.println(map.size());
            }
        }
    }
}
