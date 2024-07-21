import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt(); long[] A = new long[N];
        for (int i = 0; i < N; i++) A[i] = scanner.nextLong();

        int M = scanner.nextInt(); long[] B = new long[M];
        for (int i = 0; i < M; i++) B[i] = scanner.nextLong();

        int L = scanner.nextInt(); long[] C = new long[L];
        for (int i = 0; i < L; i++) C[i] = scanner.nextLong();

        int Q = scanner.nextInt(); long[] X = new long[Q];
        for (int i = 0; i < Q; i++) X[i] = scanner.nextLong();


        HashSet<Long> set = new HashSet<>();
        for (int i=0; i < N; i++) for (int j=0; j < M; j++) for (int k=0; k < L; k++) {
            set.add(A[i] + B[j] + C[k]);
        }

        /* algorithm */
        for (int i = 0; i < Q; i++) {
            if (set.contains(X[i])) System.out.println("Yes");
            else System.out.println("No");
        }
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
