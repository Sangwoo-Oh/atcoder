import java.lang.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int a; int b;
    public Pair(int a, int b) {this.a=a;this.b=b;}
    @Override
    public int compareTo(Pair o) {
        return this.a - o.a;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Pair[] ab = new Pair[n];
        for (int i = 0; i < n; i++) {
            ab[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(ab);

        long[] c = new long[n];
        for (int i = 0; i < n; i++ ) {
            c[i] = ab[i].b;
        }

        for (int i = n-2; i>=0; i--) {
            c[i] += c[i+1];
        }

        // for(long l : c) {
        //     System.out.print(l + " ");
        // }

        for (int i=0; i<n; i++) {
            if (c[i] <= k) {
                if (i==0) {
                    System.out.println(1);
                } else {
                    System.out.println(ab[i-1].a + 1);
                }
                return;
            }
        }
        System.out.println(ab[n-1].a + 1);
    }
}
