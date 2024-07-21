import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        long[][] AB = new long[N][3];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            AB[i][0] = scanner.nextInt();
            AB[i][1] = scanner.nextInt();
            AB[i][2] = AB[i][1] - AB[i][0];
        }

        /* algorithm */


        /* array sort */
        Arrays.sort(AB, (a,b)->Long.compare(a[2], b[2]));
        long res = 0;
        for (int i = 0; i < N-1; i++) {
            res += AB[i][0];
        }
        res += AB[N-1][1];

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
