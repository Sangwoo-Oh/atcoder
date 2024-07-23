import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) A[i] = scanner.nextLong();

        long sum = 0;
        long min = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            if (sum < 0) min = Math.min(min, sum);
        }
        if (min == 0) {
            System.out.println(sum);
        } else {
            System.out.println(sum + (-min));
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
