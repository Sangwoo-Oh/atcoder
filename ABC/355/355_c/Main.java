import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int T = scanner.nextInt();
        int[] A = new int[T];
        for (int i = 0; i < T; i++) {
            A[i] = scanner.nextInt();
        }

        int[] row = new int[N]; int[] col = new int[N];
        int dia1 = 0; int dia2 = 0;

        /* algorithm */
        for (int k = 0; k < A.length; k++) {
            A[k]--;
            int i = A[k] / N;
            int j = A[k] % N;

            k++;
            row[i]++; if (row[i] == N ) {System.out.println(k); return;}
            col[j]++; if (col[j] == N ) {System.out.println(k); return;}
            if (i==j) dia1++; if (dia1 == N ) {System.out.println(k); return;}
            if (i+j==N-1) dia2++; if (dia2 == N ) {System.out.println(k); return;}
            --k;
        }
        /* output */
        System.out.println("-1");
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
