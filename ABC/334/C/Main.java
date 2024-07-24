import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt(), K = scanner.nextInt();
        int[] cnt = new int[N]; Arrays.fill(cnt,2);
        for (int i = 0; i < K; i++) {
            int a = scanner.nextInt();
            a--; cnt[a]--;
        }

        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < N; i++) for (int j = 0; j < cnt[i]; j++) x.add(i);

        N = x.size();
        if (N % 2 == 0) {
            int ans = 0;
            for (int i = 0; i < N/2; i++) ans += x.get(i*2+1) - x.get(i*2);
            System.out.println(ans);
        } else {
            int now = 0;
            for (int i = 0; i < N/2; i++) now += x.get(i*2+2) - x.get(i*2+1);
            int ans = now;
            for (int i = 2; i < N; i += 2) {
                now += x.get(i-1) - x.get(i-2);
                now -= x.get(i) - x.get(i-1);
                ans = Math.min(ans, now);
            }
            System.out.println(ans);
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
