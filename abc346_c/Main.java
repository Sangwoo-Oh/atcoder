import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        long K = scanner.nextLong();
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(scanner.nextLong());
        }

        long sum = 0;
        for(Long e : set) {
            if (1 <= e && e <= K) sum += e;
        }
        long triangle = (K * (K + 1)) / 2;


        /* output */
        System.out.println(triangle - sum);
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
