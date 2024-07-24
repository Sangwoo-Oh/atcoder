import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) {
            board[i][j] = scanner.nextInt() - 1;
        }

        int[][] yoko = new int[9][9];
        int[][] tate = new int[9][9];
        int[][] shikaku = new int[9][9];

        for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) {
            if (yoko[i][board[i][j]] == 1) {
                System.out.println("No");
                return;
            }
            if (tate[j][board[i][j]] == 1) {
                System.out.println("No");
                return;
            }
            if (shikaku[(i/3 * 3) + j/3][board[i][j]] == 1) {
                System.out.println("No");
                return;
            }
            yoko[i][board[i][j]] = 1;
            tate[j][board[i][j]] = 1;
            shikaku[(i/3 * 3) + (j/3)][board[i][j]] = 1;
            // System.out.println((i/3 * 3) + j/3);
        }

        System.out.println("Yes");
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
