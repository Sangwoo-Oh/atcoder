import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = scanner.nextInt();

        for (int r=0; r<k; r++) {
            ArrayList<Integer> b = new ArrayList<>();
            for(int i=r; i<n; i+=k) b.add(a[i]);
            Collections.sort(b);
            for(int i=r; i<n; i+=k) a[i]=b.get(i/k);
        }

        for(int i=1; i<n; i++) {
            if(a[i-1] > a[i]) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
