import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        int n = s.length();
        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    if (s.charAt(i) == 'A' && s.charAt(j) == 'B' && s.charAt(k) == 'C') {
                        if (i < j && j < k) {
                            if (k-j == j - i) {
                                res += 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
