import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* input */
        int n = sc.nextInt();
        int[] a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            map.put(a[i], i+1);
        }

        int cnt = 0;
        int person = map.get(-1);
        while (true) {
            System.out.print(person + " ");
            if (map.containsKey(person)) person = map.get(person);
            else break;
        }

        /* output */
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
