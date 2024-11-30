import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        String t = scanner.next();

        if (s.equals(t)) {
            System.out.println(0);
            return;
        }

        if (s.length() == t.length()) {
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    System.out.println(i+1);
                    return;
                }
            }
        }

        if (s.length() < t.length()) {
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    System.out.println(i+1);
                    return;
                }
            }
            System.out.println(s.length()+1);
            return;
        }
        if (s.length() > t.length()) {
            for (int i=0; i<t.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    System.out.println(i+1);
                    return;
                }
            }
            System.out.println(t.length()+1);
            return;
        }
    }
}
