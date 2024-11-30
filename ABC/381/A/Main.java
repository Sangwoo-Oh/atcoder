import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String s = scanner.next();

        if (n % 2 != 1) {
            System.out.println("No");
            return;
        } 

        for (int i=0; i<((n+1)/2)-1; i++) {
            if (s.charAt(i) != '1') {
                System.out.println("No");
                return;
            }
        }

        if (s.charAt(((n+1)/2)-1) != '/') {
            System.out.println("No");
            return;
        }

        for (int i=(n+1)/2; i<n; i++) {
            if (s.charAt(i) != '2') {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");    
    }
}
