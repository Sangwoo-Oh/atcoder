import java.lang.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int x;
    int w;
    Pair(int x, int w) {
        this.x = x;
        this.w = w;
    }

    @Override
    public int compareTo(Pair p) {
        return this.w - p.w;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String s = scanner.next();
        Pair[] m = new Pair[n];
        int num = 0;
        int numLast = 0;
        for (int i=0; i<n; i++) {
            m[i] = new Pair(s.charAt(i), scanner.nextInt());
            if (s.charAt(i) == '1') {
                num++;
            } else numLast++;
        }

        Arrays.sort(m);

        int ans = num;
        for (int i=0; i<n; i++) {
            if (m[i].x == '1') {
                num -= 1;
            } else {
                num += 1;
            }
            if (i < n-1) {
                if(m[i].w != m[i+1].w) {
                    ans = Math.max(ans, num);
                }
            }
        }

        System.out.println(Math.max(ans, numLast));
    }
}
