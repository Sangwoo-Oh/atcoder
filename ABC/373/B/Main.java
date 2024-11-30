import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=1; i<=26; i++) {
            map.put(s.charAt(i-1), i);
        }

        int sum = 0;
        int current = map.get('A');
        for (int i=1; i<26; i++) {
            int next = map.get((char)('A' + i));
            sum += Math.abs(next - current);
            current = next;
        }
        
        System.out.println(sum);
    }
}
