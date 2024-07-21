import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String S = scanner.nextLine();
        long n = S.length();
        HashMap<Character, Long> map = new HashMap<>();

        for (Character c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, (long)0) + 1);
        }

        long combination = (n * (n-1))/2;

        long duplicate = 0;
        for (Map.Entry<Character, Long> e : map.entrySet()) {
            long k = e.getValue();
            duplicate += (k * (k-1))/2;
        }

        if (duplicate < 1) System.out.println(combination);
        else System.out.println(combination - duplicate + 1);
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
