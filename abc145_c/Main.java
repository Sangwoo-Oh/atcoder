import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            A[i][0] = scanner.nextInt();
            A[i][1] = scanner.nextInt();
        }

        /* algorithm */
        double res = 0;
        int cnt = 0;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }

        /* next permutation loop snippet */
        do {
            cnt++;
            for (int i = 1; i < array.length; i++) {
                res += Math.sqrt(
                    Math.pow(A[array[i-1]][0] - A[array[i]][0], 2) +
                    Math.pow(A[array[i-1]][1] - A[array[i]][1], 2)
                );
            }
        } while (next_permutation(array, 0, array.length));

        /* output */
        res /= cnt;
        // System.out.printf("%.10f\n" ,res);
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
