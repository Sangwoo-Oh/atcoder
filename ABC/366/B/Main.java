import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String[] s = new String[n];
        int m = 0;
        for (int i=0; i<n; i++) {
            s[i]=scanner.next();
            m = Math.max(m, s[i].length());
        }

        for (int i=0; i<n; i++) {
            int k = s[i].length();
            for (int j=0; j<m; j++) {
                if (j>=k) s[i] = s[i].concat("*");
            }
        }

        for (int j=m-1; j>=0; j--) {
            int i = 0;
            while (i < n && s[i].charAt(j)=='*') {
                s[i] = s[i].substring(0, j);
                i++;
            }
        }

        for (int j=0; j<m; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i=n-1; i>=0; i--) {
                int k = s[i].length();
                if (k>j) sb.append(s[i].charAt(j));
            }
            System.out.println(sb.toString());
        }
    }
}
