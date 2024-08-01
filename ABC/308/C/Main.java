import java.lang.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int a;
    Long w;
    Long l;
    public Pair(int a, long w, long l) {this.a=a;this.w=w;this.l=l;}
    @Override
    public int compareTo(Pair o) {
        Long me = this.w*(o.w+o.l);
        return me.compareTo(o.w*(this.w+this.l));
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        Pair[] ab = new Pair[n];
        for (int i = 0; i < n; i++) {
            long w = scanner.nextLong();
            long l = scanner.nextLong();
            ab[i] = new Pair(i+1, w, l);
        }

        Arrays.sort(ab, Collections.reverseOrder());

        for (int i = 0; i < n; i++ ) {
            System.out.print((ab[i].a) + " ");
        }
        System.out.println();
    }
}
