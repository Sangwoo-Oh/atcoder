import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        int count = 0;
        boolean isContinue = true;
        while (isContinue) {
            for (int i = 0; i < N; i++) {
                if(A[i] % 2 != 0) {
                    System.out.println(count);
                    return;
                }
                A[i] = A[i] / 2;
            }
            for (int i = 0; i < N; i++) {
                if(A[i] == 1) {
                    isContinue = true;
                }
            }
            count += 1;
        }
        System.out.println(count);
    }
}
