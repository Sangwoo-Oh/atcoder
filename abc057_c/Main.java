import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        long N = scanner.nextLong();

        //algorithm
        int res = Integer.MAX_VALUE;
        for (long i = 1; i <= Math.sqrt(N); i++) {
            if (N % i != 0) {
                continue;
            }
            long j = N / i;
            long big = Math.max(i,j);
            int digit = String.valueOf(big).length();
            res = Math.min(res, digit);
        }

        System.out.println(res);
    }
}
