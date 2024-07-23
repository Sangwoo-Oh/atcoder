import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int[] Q = new int[N];
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) Q[i] = scanner.nextInt();
        for (int i = 0; i < N; i++) A[i] = scanner.nextInt();
        for (int i = 0; i < N; i++) B[i] = scanner.nextInt();

        // algorithm
        int max = Integer.MIN_VALUE;
        int[] rest = new int[N];
        for (int i = 0; ; i++) {
            boolean stop = false;
            int j = Integer.MAX_VALUE;
            for (int k = 0; k < N; k++) {
                rest[k] = Q[k];
                rest[k] -= A[k]*i;
                if (rest[k] < 0) { stop = true; break; }
                if (B[k] == 0) continue;
                j = Math.min(j, rest[k] / B[k]);
            }
            if (stop) break;
            max = Math.max(max, i + j);
        }
        /* output */
        System.out.println(max);
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
