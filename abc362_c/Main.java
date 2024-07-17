import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        long[] L = new long[N];
        long[] R = new long[N];
        boolean exist = true;
        long leftSum = 0;
        long rightSum = 0;
        for (int i = 0; i < N; i++) {
            L[i] = scanner.nextInt();
            R[i] = scanner.nextInt();
            leftSum += L[i];
            rightSum += R[i];
        }

        if (leftSum > 0 || rightSum < 0) {
            System.out.println("No");
            return;
        }

        long[] result = L;
        long rem = -leftSum;
        for (int i = 0; i < N; i++) {
            long canAdd = R[i] - L[i];
            if (canAdd < rem) {
                result[i] = R[i];
                rem -= canAdd;
            } else {
                result[i] += rem;
                break;
            }
        }

        /* output */
        System.out.println("Yes");
        int i = 1;
        for (Long x : result) {
            System.out.print(x);
            if (i != result.length) {
                System.out.print(" ");
            } else {
                System.out.print("\n");
            }
            i++;
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
