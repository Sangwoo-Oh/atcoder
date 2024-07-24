import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String S = scanner.next();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int total = 0;
            int muji = 0;
            while (i < N && S.charAt(i) != '0') {
                total++;
                if (S.charAt(i) == '1') muji++;
                i++;
            }
            if (total == 0) continue;
            int num = 0;
            if (muji - M > 0) {
                num = total - M;
            } else {
                num = total - muji;
            }
            ans = Math.max(ans, num);
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
