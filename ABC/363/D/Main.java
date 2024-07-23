import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long N = scanner.nextLong();

        if (N==1) {
            System.out.println(0);
            return;
        }
        N--;

        for (int keta = 1;;keta++) {
            int l = ((keta + 1) / 2);
            long num = 9;
            for (int i = 0; i < l-1; i++) num *= 10;
            if (N > num) {
                N -= num;
                continue;
            }

            N += num/9 - 1;
            String s = String.valueOf(N);
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length()/2; i++) {
                char x = chars[i];
                chars[i] = chars[s.length()-i-1];
                chars[s.length()-i-1] = x;
            }
            String rs = new String(chars);
            if (keta % 2 == 1) s = s.substring(0,s.length()-1);
            String ans = s.concat(rs);
            System.out.println(ans);
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
