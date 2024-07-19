import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int N = scanner.nextInt();
        int[][] Card = new int[N][3];
        for (int i = 0; i < N; i++) {
            Card[i][0] = scanner.nextInt();
            Card[i][1] = scanner.nextInt();
            Card[i][2] = i + 1;
        }

        /* algorithm */
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(Card, (a,b)->Integer.compare(a[1], b[1]));
        for(int i = 0;i < N;i++){
            if(max <= Card[i][0]){
                list.add(Card[i][2]);
                max = Card[i][0];
            }
        }

        /* output */
        list.sort(null);
        System.out.println(list.size());
        for(int i:list){
            System.out.print(i+" ");
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
