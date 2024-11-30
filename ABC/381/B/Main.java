import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        int n = s.length();

        if (n % 2 != 0) {
            System.out.println("No");
            return;
        }


        for (int i=0; i<n/2; i++) {
            if (s.charAt(2*i) != s.charAt(2*i+1)) {
                System.out.println("No");
                return;
            }
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }

        for (int count  : map.values()) {
            if (count != 2) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");    
    }
}
