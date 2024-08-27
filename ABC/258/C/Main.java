import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        String s = scanner.next();

        int p = 0;
        for (int i = 0; i < q; i++) {
            int t = scanner.nextInt();
            int x = scanner.nextInt();

            if (t == 1) {
                // 配列を負の方向に循環するときの添え字処理
                p = ((p - x) % n + n) % n;
            } else {
                int c = (p + x - 1) % n;
                System.out.println(s.charAt(c));
            }
        }
    }
}
