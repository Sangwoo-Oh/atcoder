import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[3*n];
        for (int i = 0; i < 3*n; i++) {
            a[i]=scanner.nextInt();
        }
        int[] b = new int[n+1];

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i < 3*n; i++) {
            b[a[i]]++;
            if (b[a[i]] == 2) ans.add(a[i]);
        }

        for (int num : ans ) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
