import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int r = Math.abs(a-b);
        int ans = 0;
        if (r > 0) {
            ans += 2;
        }
        if (r % 2 == 0) ans += 1;
        System.out.println(ans);
    }
}
