import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i<n; i++ ) {
            a[i] = scanner.nextInt();
            b[i] = a[i];
        }
        Arrays.sort(b);
        for (int i = 0; i<n; i++ ) {
            if(a[i]==b[n-2]) {
                System.out.println(i+1);
                return;
            }
        }

    }
}
