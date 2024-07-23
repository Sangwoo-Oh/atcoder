import java.lang.*;
import java.util.*;

public class Main {
    static HashMap<Long, Long> map;

    static long recDivide(long num) {
        if (num == 1) return 0;
        if (map.containsKey(num)) {
            return map.get(num);
        } else {
            long a, b;
            if (num % 2 == 0) {
                a = num/2;
                b = num/2;
            } else {
                a = num/2;
                b = num/2 + 1;
            }
            long ans = num + recDivide(a) + recDivide(b);
            map.put(num, ans);
            return ans;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long N = scanner.nextLong();
        map = new HashMap<>();
        long sum = 0;
        sum = recDivide(N);
        System.out.println(sum);
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
