import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int[] P = new int[N];
        int[] Q = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            Q[i] = scanner.nextInt();
        }

        /* algorithm */
        int res = 0;
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = i + 1;
        }

        int order = 0;
        int a = 0;
        int b = 0;
        /* next permutation loop snippet */
        do {
            boolean isSame = true;
            for (int i = 0; i < N; i++) {
                if (P[i] != A[i]) isSame = false;
            }
            if (isSame) {
                a = order;
            }

            isSame = true;
            for (int i = 0; i < N; i++) {
                if (Q[i] != A[i]) isSame = false;
            }
            if (isSame) {
                b = order;
            }
            order += 1;
        } while (next_permutation(A, 0, A.length));

        /* output */
        res = Math.abs(a-b);
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
