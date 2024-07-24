import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        String S = scanner.next();

        int[] consecutive = new int[N];
        int sum = 0;
        for (int i = 0; i < S.length()-1; i++) {
            consecutive[i] = sum;
            if (S.charAt(i) == S.charAt(i+1)) {
                consecutive[i] += 1;
                sum += 1;
            }
        }

        for (int i = 0; i < Q; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            if (l == 0) {
                if (r == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(consecutive[r-1]);
                }
            } else {
                System.out.println(consecutive[r-1] - consecutive[l-1]);
            }
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
