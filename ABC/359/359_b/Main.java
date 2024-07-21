import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int[] A = new int[2*N];
        for (int i = 0; i < 2*N; i++) {
            A[i] = scanner.nextInt();
        }

        int count = 0;

        for (int i = 0; i < 2*N - 2; i++) {
            if (A[i] == A[i+2]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
