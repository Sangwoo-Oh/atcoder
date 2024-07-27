import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* input */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        int[] c = new int[n];
        for (int i=0; i<n; i++) {
            c[i] = scanner.nextInt() - 1;
        }

        char[] next = new char[m]; Arrays.fill(next, '.');
        char[] ans = new char[n]; Arrays.fill(ans, '.');
        for (int i=0; i<n; i++) {
            if(next[c[i]] == '.') {
                next[c[i]] = s.charAt(i);
            } else {
                ans[i] = next[c[i]];
                next[c[i]] = s.charAt(i);
            }
        }

        for (int i=0; i<n; i++) {
            if (ans[i] == '.') ans[i] = next[c[i]];
        }

        System.out.println(new String(ans));
    }
}
