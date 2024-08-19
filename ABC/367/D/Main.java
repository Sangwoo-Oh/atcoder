import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 入力を受け取る
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] a = new long[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextLong();
        }
        long[] b = new long[n+1];
        for (int i=1; i<n; i++) {
            b[i] = b[i] + a[i];
        }
        int count= 0;
        for (int i=0; i<n; i++) {
            if (b[i] % m == 0) count++;
            long x = b[i] - a[i-1] + a[n-1] - a[n-i-1];
            if (x % m == 0) count++;
        }

        System.out.println(count);
    }
}
