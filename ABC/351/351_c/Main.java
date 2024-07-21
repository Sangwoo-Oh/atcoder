import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextLong();

        Stack<Long> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(a[i]);
            while (stack.size() > 1) {
                long top1 = stack.pop();
                long top2 = stack.pop();
                if (top1 != top2) {
                    stack.push(top2);
                    stack.push(top1);
                    break;
                } else {
                    stack.push(top1 + (long)1);
                }
            }
        }

        /* output */
        System.out.println(stack.size());
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
