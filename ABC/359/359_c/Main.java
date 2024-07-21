import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long sx = scanner.nextLong();
        long sy = scanner.nextLong();
        long tx = scanner.nextLong();
        long ty = scanner.nextLong();

        /* algorithm */
        long res = 0;

        if ((sx + sy) % 2 == 1) sx--;
        if ((tx + ty) % 2 == 1) tx--;

        long x = Math.abs(sx-tx);
        long y = Math.abs(sy-ty);

        if (x < y) {
            res = y;
        } else {
            res = (x + y) / 2;
        }

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
