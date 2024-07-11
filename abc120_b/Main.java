import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int K = scanner.nextInt();

        //algorithm
        int res = 0;
        for (int i = Math.min(A,B); i >= 1; i--) {
            if (A % i == 0 && B % i == 0) {
                K--;
                if (K==0) {
                    res = i;
                }
            }
        }

        System.out.println(res);
    }
}
