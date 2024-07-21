import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long[] D = new long[N*2];
        for (int i = 0; i < N; i++) {
            D[i] = scanner.nextLong() % (A+B);
        }
        for (int i = 0; i < N; i++) {
            D[N + i] = D[i] + A + B;
        }

        Arrays.sort(D);
        for (int i = 1; i < N*2; i++) {
            if (D[i] - D[i-1] - 1 >= B) {
                System.out.println("Yes"); return;
            }
        }
        System.out.println("No");
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
