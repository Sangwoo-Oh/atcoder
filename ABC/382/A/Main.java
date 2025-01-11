import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        String s = scanner.next();

        int count = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '.') {
                count++;
            }
        }
        count += d;
        System.out.println(count);    
    }
}
