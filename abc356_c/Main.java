import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        int[][] A = new int[M][];
        String[] R = new String[M];
        for (int i = 0; i < M; i++) {
            A[i] = new int[scanner.nextInt()];
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = scanner.nextInt() - 1;
            }
            R[i] = scanner.next();
        }

        /* algorithm */
        int res = 0;
        for (int bit = 0; bit < (1 << N); bit++) {
            boolean valid = true;
            for (int i = 0; i < M; i++) {
                // check if each ith test case is valid
                int cnt = 0;
                for (int j = 0; j < A[i].length; j++) {
                    if (((bit >> A[i][j]) & 1) == 1) {
                        cnt += 1;
                    }
                }
                if (cnt >= K && R[i].equals("x")) valid = false;
                if (cnt < K && R[i].equals("o")) valid = false;
            }
            if (valid) {
                ++res;
            }
        }

        /* output */
        System.out.println(res);
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
