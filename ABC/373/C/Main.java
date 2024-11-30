import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        Long[] a = new Long[n];
        Long[] b = new Long[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextLong();
        }
        for (int i=0; i<n; i++) {
            b[i] = scanner.nextLong();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(a[n-1] + b[n-1]);
    }   
}
