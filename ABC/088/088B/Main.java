import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);

        int A = 0;
        int B = 0;
        boolean turn = true;
        for (int i = N - 1; i >= 0; i--) {
            if (turn) {
                A += a[i];
            } else {
                B += a[i];
            }
            turn = turn ? false : true;
        }
        System.out.println(A-B);
    }
}
