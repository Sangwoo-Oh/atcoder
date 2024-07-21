import java.util.*;
import java.lang.*;

public class Main {
    static String S;
    static String T;
    public static boolean judge(String S, String T) {
        S = S.toUpperCase();
        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(j)) {
                j++;
                if (j==3) return true;
            }
        }
        if (j==2 && 'X' == T.charAt(j)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        S = scanner.nextLine();
        T = scanner.nextLine();


        /* output */
        if (judge(S,T)) System.out.println("Yes");
        else System.out.println("No");
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
