import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> s = new ArrayList<>();
        for (int i=0; i<m; i++) {
            int c = scanner.nextInt();
            s.add(new ArrayList<>());
            for (int j=0; j<c; j++) {
                int a = scanner.nextInt();
                s.get(i).add(a);
            }
        }

        int ans = 0;
        for (int bit=1; bit<(1<<m); bit++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i=0; i<m; i++) {
                if(((bit>>i)&1)!=1) continue;
                set.addAll(s.get(i));
            }
            if (set.size()==n) ans++;
        }

        System.out.println(ans);
    }
}
