import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N]; for (int i = 0; i < N; i++) A[i] = scanner.nextInt();

        Arrays.sort(A);

        int r = 0;
        int now = 1;
        while (r < N-1 && A[r+1]-A[r] < M) {
            M -= A[r+1]-A[r];
            now++;
            r++;
        }

        int ans = now;
        for (int k = 1; k < N; k++) {
            M += A[k] - A[k-1];
            now--;
            while (r < N-1 && A[r+1]-A[r] < M) {
                M -= A[r+1]-A[r];
                now++;
                r++;
            }
            ans = Math.max(ans, now);
        }

        System.out.println(ans);
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
