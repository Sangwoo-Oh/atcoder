import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] s = new char[n][n];
        char[][] t = new char[m][m];
        for (int i=0; i<n; i++) {
            String row = scanner.next();
            for (int j=0; j<n; j++) {
                s[i][j] = row.charAt(j);
            }
        }
        for (int i=0; i<m; i++) {
            String row = scanner.next();
            for (int j=0; j<m; j++) {
                t[i][j] = row.charAt(j);
            }
        }
        // for (int i=0; i<m`; i++) {
        //     for (int j=0; j<n; j++) {
        //         System.out.print(s[i][j]);
        //     }
        //     System.out.println();
        // }

        for (int i=0; i<n-m+1; i++) {
            for (int j=0; j<n-m+1; j++) {
                boolean ok = true;
                for (int ii=0; ii<m; ii++) {
                    for (int jj=0; jj<m; jj++) {
                        if (s[i+ii][j+jj] != t[ii][jj]) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) {
                        break;
                    }
                }
                if(ok) {
                    System.out.println((i+1) + " " + (j+1));
                }
            }
        }
    }
}
