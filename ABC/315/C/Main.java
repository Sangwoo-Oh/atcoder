import java.lang.*;
import java.util.*;

class IceCream implements Comparable<IceCream> {
    int color;
    long point;

    IceCream(int color, long point) {
        this.color = color;
        this.point = point;
    }

    @Override
    public int compareTo(IceCream o) {
        return Long.compare(this.point, o.point);
    }
}

public class Main {
    static int n;
    public static void main(String[] args) {
        /* input */
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        IceCream[] iceCreams = new IceCream[n];
        for (int i=0; i<n; i++) {
            int f = scanner.nextInt();
            long s = scanner.nextLong();
            iceCreams[i] = new IceCream(f,s);
        }

        Arrays.sort(iceCreams, (x,y)->Long.compare(y.point, x.point));

        IceCream s = iceCreams[0];

        long ans = Long.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            IceCream t = iceCreams[i];
            if (t.color == s.color) {
                ans = Math.max(ans, s.point + t.point/2);
            } else {
                ans = Math.max(ans, s.point + t.point);
            }
        }
        System.out.println(ans);
    }
}
