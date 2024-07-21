import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] ab = new int[M][2];
        for (int i = 0; i < M; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }

        /* algorithm */
        int res = 0;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) array[i] = i + 1;

        /* next permutation loop snippet */
        do {
            if (array[0] != 1) continue;
            int path = 0;
            for (int i = 0; i < N-1; i++) {
                for (int j = 0; j < M; j++) {
                    if (array[i] == ab[j][0] && array[i+1] == ab[j][1]) {
                        path++;
                    } else if (array[i+1] == ab[j][0] && array[i] == ab[j][1]) {
                        path++;
                    }
                }
            }
            if (path==N-1) {
                res++;
            }
        } while (next_permutation(array, 0, array.length));

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
