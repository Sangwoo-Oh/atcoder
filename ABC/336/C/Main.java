import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long N = scanner.nextLong();

        if (N == 1) { System.out.println(0); return; }
        N--;

        StringBuilder sb = new StringBuilder();
        for (int digit = 1; ;digit++){
            if (N - 4 * Math.pow(5,digit-1) > 0) {
                N -= 4 * Math.pow(5,digit-1);
                continue;
            }

            // first digit
            int num = 1;
            while (N - Math.pow(5,digit-1) > 0) {
                num++;
                N -= Math.pow(5,digit-1);
            }
            sb.append(num*2);

            digit--;
            while (digit > 0) {
                num = 0;
                while (N - Math.pow(5,digit-1) > 0) {
                    num++;
                    N -= Math.pow(5,digit-1);
                }
                sb.append(num*2);
                digit--;
            }

            System.out.println(sb.toString());
            return;
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
