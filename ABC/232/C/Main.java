import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] AB = new int[n][n];
        int[][] CD = new int[n][n];
        for (int i=0; i<m; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            AB[a][b] = 1;
            AB[b][a] = 1;
        }
        for (int i=0; i<m; i++) {
            int c = scanner.nextInt()-1;
            int d = scanner.nextInt()-1;
            CD[c][d] = 1;
            CD[d][c] = 1;
        }

        int[] perm = new int[n];
        for (int i=0; i<n; i++) perm[i] = i;

        do {
            int[][] G = new int[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (CD[i][j] == 1) G[perm[i]][perm[j]] = 1;
                    else G[perm[i]][perm[j]] = 0;
                }
            }

            boolean ok = true;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (AB[i][j] != G[i][j]) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                System.out.println("Yes");
                return;
            }
        } while (next_permutation(perm, 0, n));


        System.out.println("No");
    }

    static void dfs(int v, List<List<Integer>> AB, int[] first_order, int[] last_order, int[] visited, int first_ptr, int last_ptr) {
        visited[v] = 1;
        first_order[v] = first_ptr++;
        for (int u : AB.get(v)) {
            if (visited[u] == 0) {
                dfs(u, AB, first_order, last_order, visited, first_ptr, last_ptr);
            }
        }
        last_order[v] = last_ptr++;
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
