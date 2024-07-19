import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int[][] xy = new int[3][2];
        for (int i = 0; i < 3; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }

        double ab = Math.pow(xy[0][0] - xy[1][0],2) + Math.pow(xy[0][1] - xy[1][1],2);
        double bc = Math.pow(xy[1][0] - xy[2][0],2) + Math.pow(xy[1][1] - xy[2][1],2);
        double ca = Math.pow(xy[2][0] - xy[0][0],2) + Math.pow(xy[2][1] - xy[0][1],2);

        boolean res = false;
        if (ab >= bc && ab >= ca) {
            res = ab == bc + ca;
        } else if (bc >= ab && bc >= ca) {
            res = bc == ab + ca;
        } else {
            res = ca == ab + bc;
        }

        System.out.println(res ? "Yes" : "No");
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
