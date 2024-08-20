import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long x = scanner.nextLong();
        long a = scanner.nextLong();
        long d = scanner.nextLong();
        long n = scanner.nextLong();

        if(d < 0) { // 数列を反転させる
            a = a + (n-1)*d; // 初項を元の数列の末項に
            d = -d; // 交差を-1倍
        }

        long ok = 0;
        long ng = n+1;

        // x 以下で最大のok番目 -> ok
        while (Math.abs(ok-ng)>1) {
            long mid = (ok+ng)/2;
            long mid_num = a+(mid-1)*d;
            if (mid_num<=x) {
                ok=mid;
            } else {
                ng=mid;
            }
        }

        if (ok==0){
            System.out.println(Math.abs(a-x));
            return;
        } else if (ng==n+1){
            System.out.println(Math.abs(a+(n-1)*d-x));
            return;
        }

        long ans = Math.min(Math.abs((a+(ok-1)*d)-x), Math.abs((a+(ok)*d)-x));

        System.out.println(ans);
    }
}
