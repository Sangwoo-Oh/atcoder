import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        String S = scanner.next();

        int l = 0;
        int r = 0;

        int[] alphabet = new int[26];
        int ans = 0;
        while (r < N) {
            int index = (int)S.charAt(r) - 'a';
            if (alphabet[index] < r-l+1) {
                ans++;
                alphabet[index]++;
            }
            r++;
            if (r < N && S.charAt(r) != S.charAt(r-1)) l = r;
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
