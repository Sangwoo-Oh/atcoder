import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] K = new int[M][];
        for (int i = 0; i < M; i++) {
            K[i] = new int[scanner.nextInt()];
            for (int j = 0; j < K[i].length; j++) {
                K[i][j] = scanner.nextInt() - 1;
            }
        }
        int[] P = new int[M];
        for (int i = 0; i < M; i++) {
            P[i] = scanner.nextInt();
        }

        //algorithm
        int res = 0;
        for (int bit = 0; bit < (1 << N); bit++) {
            boolean all = true;
            for (int i = 0; i < M; i++) {
                int sum = 0;
                for (int j = 0; j < K[i].length; j++) {
                    if ((bit >> K[i][j] & 1)== 1) {
                        sum += 1;
                    }
                }
                if (sum % 2 != P[i]) {
                    all = false;
                }
            }
            if (all) res++;
        }

        System.out.println(res);
    }
}
