import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String[] s = new String[n];
        for (int i=0; i<n; i++) {
            s[i] = scanner.next();
        }

        int[][] occur = new int[n][10];
        for (int i=0; i<n; i++) {
            for (int j=0; j<10; j++) {
                occur[i][Character.getNumericValue(s[i].charAt(j))] = j;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int num=0; num<10; num++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i=0; i<n; i++) {
                map.put(occur[i][num], map.getOrDefault(occur[i][num], 0) + 1);
            }
            List<Integer> time = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                for (int i=1; i <= entry.getValue(); i++) {
                    time.add(entry.getKey() + 10 * (i-1));
                }
            }
            Collections.sort(time);
            Collections.reverse(time);
            min = Math.min(min, time.get(0));
        }
        System.out.println(min);
    }
}
