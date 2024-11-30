import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String s = scanner.next();

        int max = 1;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) != '/') continue;

            int count = 1;
            int left = i-1;
            int right = i+1;
            while (true) {
                if (left < 0 || right >= n) break;
                if (s.charAt(left) != '1') break;
                if (s.charAt(right) != '2') break;

                count += 2;
                left--;
                right++;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);    
    }
}
