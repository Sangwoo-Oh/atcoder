import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] K = new int[M];
        for (int i = 0; i < M; i++) {
            K[i] = scanner.nextInt();
        }
        String S = scanner.nextLine();
        String S = scanner.next();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        //algorithm
        int res = 0;
        // int cnt = 0;
        // int sum = 0;
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }



        System.out.println(res);
    }
}
