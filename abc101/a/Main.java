import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();

        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '+') {
                ans++;
            } else {
                ans--;
            }
        }

        System.out.println(ans);
    }
}
