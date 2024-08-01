import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            char[] c = s.toCharArray();
            reverse(c);
            if (!set.contains(s) && !set.contains(new String(c))) {
                set.add(s);
            }
        }
        System.out.println(set.size());
    }
    public static void reverse(char[] c) {
        for (int i = 0; i < c.length/2; i++){
            char tmp = c[i];
            c[i] = c[c.length-i-1];
            c[c.length-i-1] = tmp;
        }
    }
}
