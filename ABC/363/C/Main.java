import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        String S = scanner.next();
        char[] chars = S.toCharArray();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = (int)chars[i];
        }

        Arrays.sort(A);

        int combination = 0;
        HashSet<String> set = new HashSet<>();
        do {
            StringBuilder sb = new StringBuilder();
            for (int a : A) {
                sb.append((char)a);
            }
            String str = sb.toString();
            // do something
            combination += 1;

            for (int i = 0; i <= N-K; i++) {
                boolean isPali = true;
                String subStr = str.substring(i, i + K);
                for (int j=0; j < subStr.length() / 2; j++) {
                    if (subStr.charAt(j) != subStr.charAt(subStr.length()-1-j)) {
                        isPali = false;
                        break;
                    }
                }
                if (isPali) {
                    combination -= 1;
                    break;
                }
            }
        } while (next_permutation(A, 0, A.length));

        /* output */
        System.out.println(combination);
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
