import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int R = scanner.nextInt();
        int G = scanner.nextInt();
        int B = scanner.nextInt();
        String c = scanner.next();

        /* algorithm */
        int res = 0;
        if (c.equals("Red")) {
            res = Math.min(G,B);
        } else if (c.equals("Green")) {
                res = Math.min(R,B);
            } else {
                res = Math.min(R,G);
            }

        /* array sort */
        // Arrays.sort(Card, (a,b)->Integer.compare(a[1], b[1]));

        /* next permutation loop snippet */
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
