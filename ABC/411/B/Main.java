import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        
        int[] d = new int[n-1];
        int[][] dd = new int[n][n];
        for (int i=0; i<n-1; i++) {
            d[i] = scanner.nextInt();
        }
        for (int i=0; i<n-1; i++) {
            int dist = 0;
            for (int j=i; j<n-1; j++) {
                dist += d[j];
                System.out.printf(dist + " ");
            }
            System.out.println();
        }
    }
}
