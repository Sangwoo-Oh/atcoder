import java.util.*;
import java.lang.*;

public class Main {

    public static boolean judge(int N, int bit, int[][][] pair) {
        for (int i = 0; i < N; i++) {
            if ((bit & (1 << i)) != (1 << i))continue;

            for (int[] xy : pair[i]) {
                int x = xy[0];
                int y = xy[1];

                if (y == 1 && (bit & (1 << x)) != (1 << x)) return false;
                if (y == 0 && (bit & (1 << x)) == (1 << x)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int[][][] pair = new int[N][][];
        for (int i = 0; i < N; i++) {
            int A = scanner.nextInt();
            pair[i] = new int[A][2];
            for (int j = 0; j < A; j++) {
                pair[i][j] = new int[2];
                pair[i][j][0] = scanner.nextInt() - 1;
                pair[i][j][1] = scanner.nextInt();
            }
        }

        //algorithm
        int res = 0;

        for (int bit = 0; bit < (1 << N); bit++) {
            if (judge(N, bit, pair)) {
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    if ((bit & (1 << i)) == (1 << i)) {
                        sum += 1;
                    }
                }
                res = Math.max(res, sum);
            }
        }

        System.out.println(res);
    }
}
