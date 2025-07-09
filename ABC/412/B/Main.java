import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        String t = scanner.next();

        HashSet<Character> set = new HashSet<>();
        for (char c : t.toCharArray()) {
            set.add(c);
        }

        for (int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c) && !set.contains(s.charAt(i-1))) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
