import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int m = scanner.nextInt();
        String[] s = new String[3];
        for (int i = 0; i < 3; i++) s[i] = scanner.next();

        int ans = Integer.MAX_VALUE;
        for (int i=0; i<3*m; i++) {
            for (int j=0; j<3*m; j++) {
                for (int k=0; k<3*m; k++) {
                    if (i==j) continue;
                    if (i==k) continue;
                    if (j==k) continue;
                    if (s[0].charAt(i%m) == s[1].charAt(j%m) && s[0].charAt(i%m) == s[2].charAt(k%m)) {
                        ans = Math.min(ans, Math.max(Math.max(i,j), k));
                    }
                }
            }
        }
        if (ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}
