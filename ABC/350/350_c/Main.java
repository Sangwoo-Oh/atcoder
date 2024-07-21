import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i+1] = scanner.nextInt();
        }

        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            while (a[i] != i) {
                int j = a[i];
                ans.add(new int[]{i, j});
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        /* output */
        System.out.println(ans.size());
        for (int[] item : ans) {
            System.out.println(item[0] + " " + item[1]);
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
