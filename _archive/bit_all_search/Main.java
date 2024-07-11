import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int X = scanner.nextInt();
        int[] C = new int[N];
        int[][] A = new int[N][M];

        for (int i = 0; i < N; i++) {
            C[i] = scanner.nextInt();
            for (int j = 0; j < M; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        int[] res = new int[M];
        int cost = 0;
        int min = Integer.MAX_VALUE;
        boolean mastered = true;



        // bitmask
        for (int i = 0; i < 1 << N; i++) {
            for (int j = 0; j < N; j++) {
                if ((1 & (i >> j)) == 1) {
                    for (int k = 0; k < M; k++) {
                        res[k] += A[j][k];
                    }
                    cost += C[j];
                }
            }
            for (int k=0; k<M; k++) {
                if (res[k] < X ) {
                    mastered = false;
                    break;
                }
            }
            if (mastered) {
                min = Math.min(min,cost);
            }

            for (int k = 0; k < M; k++) {
                res[k] = 0;
            }
            cost = 0;
            mastered = true;
        }
        if(min != Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}
