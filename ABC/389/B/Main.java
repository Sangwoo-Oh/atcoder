import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long x = scanner.nextLong();
        for (int n=0; n<100; n++) {
            if (factorial(n) == x) {
                System.out.println(n);
                break;
            }
        }
        
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i=1; i<=n; i++) {
            result *= i;
        }
        return result;
    }
}
