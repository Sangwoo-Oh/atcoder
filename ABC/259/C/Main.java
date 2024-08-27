import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        String t = scanner.next();

        if (s.length() > t.length()) {
            System.out.println("No");
            return;
        }

        if (s.equals(t)) {
            System.out.println("Yes");
            return;
        }

        int j = 0;
        for (int i=0; i<s.length(); i++) {
            if (j < t.length() && s.charAt(i) == t.charAt(j)) {
                j++;
                continue;
            }

            while (s.charAt(i) != t.charAt(j)) {
                if (j < t.length() && i >= 2 && s.charAt(i-1) == s.charAt(i-2) && s.charAt(i-1) == t.charAt(j)) {
                    j++;
                } else {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}
