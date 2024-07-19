import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int[] A = new int[6];
        for (int i = 0; i < 6; i++) {
            A[i] = scanner.nextInt();
        }
        int[] B = new int[6];
        for (int i = 0; i < 6; i++) {
            B[i] = scanner.nextInt();
        }

        // center coordinates
        int ax = (A[3] + A[0]) / 2;
        int ay = (A[4] + A[1]) / 2;
        int az = (A[5] + A[2]) / 2;

        // distance from center
        int rax = Math.abs(A[0]-ax);
        int ray = Math.abs(A[1]-ay);
        int raz = Math.abs(A[2]-az);

        // center coordinates
        int bx = (B[3] + B[0]) / 2;
        int by = (B[4] + B[1]) / 2;
        int bz = (B[5] + B[2]) / 2;

        // distance from center
        int rbx = Math.abs(B[0]-bx);
        int rby = Math.abs(B[1]-by);
        int rbz = Math.abs(B[2]-bz);

        // distance between two center coordinates;
        int dx = Math.abs(ax - bx);
        int dy = Math.abs(ay - by);
        int dz = Math.abs(az - bz);

        if (rax + rbx > dx && ray + rby > dy  && raz + rbz > dz ) {
            System.out.println("Yes");
            return;
        }

        /* output */
        System.out.println("No");
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
