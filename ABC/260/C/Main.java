import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        // r[i] : レベルiの赤ボールが1個ある状態からスタートして、得られるレベル１の青ボールの数
        // b[i] : レベルiの青ボールが1個ある状態からスタートして、得られるレベル１の青ボールの数
        long[] r = new long[n+1];
        long[] b = new long[n+1];

        r[1] = 0;
        b[1] = 1;

        for (int i=2; i<=n; i++) {
            b[i] = r[i-1] + b[i-1]*y;
            r[i] = r[i-1] + b[i]*x;
        }

        System.out.println(r[n]);        
    }
}
