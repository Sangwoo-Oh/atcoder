import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        long N = scanner.nextLong();
        String S = scanner.nextLine();
        String S = scanner.next();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        /* algorithm */
        int res = 0;
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }


        /* next permutation loop snippet */
        do {
            for (int a : A) {
                System.out.print(a);
                System.out.print(' ');
            }
            System.out.println();
        } while (next_permutation(A, 0, A.length));

        /* output */
        System.out.println(res);
        System.out.printf("%.10f\n" ,res);
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
