import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int Q = scanner.nextInt();

        // head position
        int i = 1;
        int j = 0;
        // initialize queue
        ArrayList<int[]> q = new ArrayList<>();
        for (int k = N; k >= 1; k--) {
            q.add(new int[]{k,j});
        }

        for (int l = 0; l < Q; l++) {
            int num = scanner.nextInt();
            if (num == 1) {
                char move = scanner.next().charAt(0);
                switch (move) {
                    case 'R' -> i += 1;
                    case 'L' -> i -= 1;
                    case 'U' -> j += 1;
                    case 'D' -> j -= 1;
                }
                q.add(new int[]{i,j});
            } else {
                int t = scanner.nextInt();
                int p = q.size();
                System.out.println(q.get(p-t)[0] + " " + q.get(p-t)[1]);
            }
        }
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
