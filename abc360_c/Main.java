import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt() - 1;
        }
        int[] W = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = scanner.nextInt();
        }
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            B.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            B.get(A[i]).add(W[i]);
        }


        /* algorithm */
        int res = 0;
        for (int i = 0; i < N; i++) {
            int num = B.get(i).size();
            Collections.sort(B.get(i));
            int j = 0;
            while (num > 1) {
                res+=B.get(i).get(j);
                num--;
                j++;
            }
        }

        /* output */
        System.out.println(res);
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
