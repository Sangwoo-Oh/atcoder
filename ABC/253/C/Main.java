import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int q = scanner.nextInt();

        SortedMap<Integer, Integer> multiSet = new TreeMap<>();
        for(int i=0; i<q; i++) {
            int n = scanner.nextInt();
            if(n==1) {
                int x = scanner.nextInt();
                int occur = multiSet.getOrDefault(x, 0);
                multiSet.put(x, occur+1);
            } else if (n==2) {
                int x = scanner.nextInt();
                int c = scanner.nextInt();
                int occur = multiSet.getOrDefault(x, 0);
                if (c < occur) {
                    multiSet.put(x, occur-c);
                } else {
                    multiSet.remove(x);
                }
            } else if (n==3) {
                int max = multiSet.lastKey();
                int min = multiSet.firstKey();
                System.out.println(max-min);
            }
        }
    }
}
