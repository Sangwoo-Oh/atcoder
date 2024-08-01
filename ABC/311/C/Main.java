import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            a[i]--;
        }
        int[] b = new int[n];
        Arrays.fill(b,-1);

        int k = 0;
        int v = 0;
        while (b[v] == -1) {
            b[v] = k; k++;
            v = a[v];
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int len = k-b[v];
        for (int i = 0; i < len; i++) {
            ans.add(v+1);
            v = a[v];
        }
        System.out.println(ans.size());
        for(int u : ans) System.out.print(u + " ");
    }
}
