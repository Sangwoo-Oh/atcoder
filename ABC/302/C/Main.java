import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] s = new String[n];
        for (int i=0; i<n; i++) s[i] = scanner.next();
        int[] indices = new int[n];
        for (int i=0; i<n; i++) indices[i]=i;

        do {
            boolean ok = true;
            for (int i=0; i<n-1; i++) {
                int j = indices[i];
                int k = indices[i+1];
                if (!hami(s[j], s[k])) ok = false;
            }
            if (!ok) continue;
            System.out.println("Yes");
            return;
        } while (next_permutation(indices, 0, n));

        System.out.println("No");
    }

    static boolean hami(String a, String b) {
        int n = a.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt == 1;
    }

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
