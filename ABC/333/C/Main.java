import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        /* input */
        long[] repunit = new long[] {
            1,
            11,
            111,
            1111,
            11111,
            111111,
            1111111,
            11111111,
            111111111,
            1111111111,
            11111111111L,
            111111111111L
        };
        HashSet<Long> set = new HashSet<>();
        for (int a = 0; a < 12; a++) for (int b = 0; b < 12; b++) for (int c = 0; c < 12; c++) {
            set.add(repunit[a] + repunit[b] + repunit[c]);
        }

        long[] arr = new long[set.size()];
        int i = 0;
        for(long num : set) {
            arr[i++] = num;
        }
        Arrays.sort(arr);
        System.out.println(arr[N-1]);

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
