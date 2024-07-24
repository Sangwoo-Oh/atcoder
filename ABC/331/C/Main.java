import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int[] A = new int[N]; int[] X = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
            X[i] = A[i];
        }

        Arrays.sort(X);

        HashMap<Integer, Long> map = new HashMap<>();
        long as = 0;
        for (int i = N-1; i >= 0; i--) {
            map.put(X[i], as);
            as += X[i];
            while(i >= 1 && X[i] == X[i-1]) {
                i--;
                as += X[i];
            }
        }

        for (int i : A) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
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
