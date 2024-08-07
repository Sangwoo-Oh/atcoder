import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += 1;
            if (s.charAt(i) == '0') {
                if(i+1<n && s.charAt(i+1) == '0') {
                    i += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
