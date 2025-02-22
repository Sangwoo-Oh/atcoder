import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }

        // 石を持ってる成人の人数
        int s = 0;
        // i年後に石がなくなる成人の人数
        int[] d = new int[n];

        for (int i=0; i<n; i++) {
            a[i] += s;
            s++;
            // 何回石を渡せるか
            int num = Math.min(n-i-1, a[i]);
            // 石を渡した後の数に更新
            a[i] -= num;
            // i+num年後に石がなくなる成人を+1
            d[i+num] += 1;
            // i年に石がなくなった成人の人数をマイナス
            s -= d[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(a[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
