import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        int n = s.length();
        char[] cs  = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        
        for (int i=n-1; i>=0; i--) {
            if (cs[i] == 'A') {
                if (i>0 && cs[i-1] == 'W') {
                    cs[i] = 'C';
                    cs[i-1] = 'A';
                }
            }
        }

        String ans = new String(cs);
        System.out.println(ans);
    }
}
