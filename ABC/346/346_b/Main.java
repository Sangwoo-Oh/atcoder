import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int w = scanner.nextInt();
        int b = scanner.nextInt();
        int len = w + b;
        char[] piano = new char[]{'w','b','w','b','w','w','b','w','b','w','b','w'};

        int n = piano.length;
        for (int i = 0; i < n; i++) {
            int W = w;
            int B = b;
            int j = i;
            do {
                if (piano[j%n] == 'w') {
                    W -= 1;
                } else {
                    B -= 1;
                }
                j++;
            } while (W + B > 0);
            if (W == 0 && B == 0) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
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
