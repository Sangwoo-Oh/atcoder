import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        String ans = "";
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '2') {
                ans += s.charAt(i);
            }
        }
        System.out.println(ans);
    }
}
