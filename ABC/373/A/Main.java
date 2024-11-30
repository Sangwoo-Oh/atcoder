import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String[] s = new String[12];

        for (int i=0; i<12; i++) {
            s[i] = scanner.next();
        }

        int cnt = 0;
        for (int i=0; i<12; i++) {
            if (s[i].length() == i+1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
