import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int[] B = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            B[i] = scanner.nextInt();
        }

        /* algorithm */
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                res += B[i];
            } else if (i == N-1) {
                res += B[i-1];
            } else {
                res += Math.min(B[i-1], B[i]);
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
