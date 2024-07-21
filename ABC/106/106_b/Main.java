import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 2 != 0) {
                int divisor = 0;
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        divisor += 1;
                    }
                }
                if (divisor == 8) {
                    res += 1;
                }
            }
        }
        System.out.println(res);
    }
}
