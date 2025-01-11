import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        String s = scanner.next();

        for (int i=0; i<d; i++) {
            for (int j=n-1; j>=0; j--) {
                if (s.charAt(j) == '@') {
                    s = s.substring(0, j) + "." + s.substring(j+1);
                    break;
                }
            }
        }
        System.out.println(s);
    }
}
