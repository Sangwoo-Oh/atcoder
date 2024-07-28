import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String[] s = new String[n];

        for (int i = 0; i < n ; i++) s[i] = scanner.next();

        for (int i=1; i < n; i++) {
            if(s[i-1].equals("sweet") && s[i].equals(s[i-1])) {
                if (i<n-1) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");

    }
}
