import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        
        LinkedList<Character> list = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            list.add(c);
        }

        int res = 0;
        int n = list.size();
        for (int i=1; i<=n; i++) {
            if (i % 2 != 0) {
                if (list.get(i-1) != 'i') {
                    list.add(i-1, 'i');
                    res++;
                    n++;
                }
            } else {
                if (list.get(i-1) != 'o') {
                    list.add(i-1, 'o');
                    res++;
                    n++;
                }
            }
        }
        if (n % 2 == 1) {
            res++;
        } 
        System.out.println(res);
        // System.out.println(list.toString());
    }
}
