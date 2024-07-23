import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        String S = scanner.next();

        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char)('a' + i);
        }

        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            char C = scanner.next().charAt(0);
            char D = scanner.next().charAt(0);
            for (int j = 0; j < 26; j++)  {
                if (C == alphabet[j]) {
                    alphabet[j] = D;
                }
            }
        }

        /* output */
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            sb.append(alphabet[(int)c - 'a']);
        }

        System.out.println(sb.toString());
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
