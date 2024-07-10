import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            A[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            sum += A[i];
        }
        int required = M*N-sum;
        required = required < 0 ? 0 : required;
        System.out.println(required<=K ? required : "-1");
    }
}
