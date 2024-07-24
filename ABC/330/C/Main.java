import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long D = scanner.nextLong();

        long ans = D;
        long y = (long)2e8;
        for (long x = 0; x < (long)2e8; x++) {
            while (y > 0 && x*x + y*y > D) {
                y--;
            }
            ans = Math.min(ans, Math.abs(x*x+y*y-D));
            ans = Math.min(ans, Math.abs(x*x+(y+1)*(y+1)-D));
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
