import java.lang.*;
import java.util.*;

// housin
// next_permutation
    // GとHの隣接行列を比較して、合計金額を計算
    // 最小値を計算

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int mg = scanner.nextInt();
        int[][] G = new int[n][n];
        for (int i=0; i<mg; i++) {
            int v = scanner.nextInt()-1;
            int u = scanner.nextInt()-1;
            G[v][u] = 1;
            G[u][v] = 1;
        }

        int mh = scanner.nextInt();
        int[][] H = new int[n][n];
        for (int i=0; i<mh; i++) {
            int v = scanner.nextInt()-1;
            int u = scanner.nextInt()-1;
            H[v][u] = 1;
            H[u][v] = 1;
        }

        int[][] a = new int[n][n];
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                int cost = scanner.nextInt();
                a[i][j] = cost;
                a[j][i] = cost;
            }
        }

        int[] perm = new int[n];
        for (int i=0; i<n; i++) perm[i] = i;


        int min = Integer.MAX_VALUE;

        do {
            int[][] H_NEW = new int[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (H[i][j] == 1) H_NEW[perm[i]][perm[j]] = 1;
                    else H_NEW[perm[i]][perm[j]] = 0;
                }
            }

            int sum = 0;
            for (int i=0; i<n-1; i++) {
                for (int j=i+1; j<n; j++) {
                    if (G[i][j] != H_NEW[i][j]) {
                        sum += a[i][j];
                    }
                }
            }

            min = Math.min(min, sum);
        } while (next_permutation(perm, 0, n));
        System.out.println(min);
    }

    /* next permutation method */
    static boolean next_permutation(int[] array, int start, int end) {
        if(array == null || start > end || start < 0 || end > array.length) {
            System.out.println("Error: 引数が正しくありません。");
            return false;
        }

        for(int i=end-2; i>=start; i--) {
            if(array[i] < array[i+1]) {
                int j = end - 1;
                while(array[i] >= array[j]) {
                    j--;
                }

			    //swap
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;

                Arrays.sort(array, i+1, end);

                return true;
            }
        }
        return false;
    }
}
