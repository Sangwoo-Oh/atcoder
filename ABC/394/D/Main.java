import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        int n = s.length();

        if (n%2 == 1) {
            System.out.println("No");
            return;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '('); map.put(']', '['); map.put('>', '<');
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}
