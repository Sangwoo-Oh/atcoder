import java.lang.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int a;
    int b;
    public Pair (int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Pair o) {
        return this.b - o.b;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m]; for (int i = 0; i < m; i++) a[i] = scanner.nextInt();
        String[] s = new String[n]; for (int i = 0; i <n; i++) s[i] = scanner.next();

        for (int i = 0; i < n; i++) {
            // ith player total score
            int total = 0;
            ArrayList<Pair> b = new ArrayList<>();
            for (int j=0; j<m; j++) {
                if (s[i].charAt(j) == 'o') total += a[j];
                else b.add(new Pair(j, a[j]));
            }
            total += i + 1;

            int maxTotal = 0;
            for (int j = 0; j < n; j++) {
                int sum = 0;
                if (i==j) continue;
                for (int k = 0; k <m; k++) if (s[j].charAt(k) == 'o') sum += a[k];
                sum += j + 1;
                maxTotal = Math.max(maxTotal, sum);
            }

            Collections.sort(b);
            if (maxTotal == total) {
                System.out.println(0);
            } else {
                int diff = maxTotal - total;
                int k = b.size()-1;
                int cnt = 0;
                while (k >= 0 && diff > 0) {
                    if (s[i].charAt(b.get(k).a) == 'x') {
                        diff -= b.get(k).b;
                        cnt++;
                    }
                    k--;
                }
                System.out.println(cnt);
            }

        }
    }
}
