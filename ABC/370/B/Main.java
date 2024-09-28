import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        List<List<Integer>> a = new ArrayList<>();
        for (int i=0; i<n; i++) {
            a.add(new ArrayList<>());
            for (int j=0; j<=i; j++) {
                a.get(i).add(scanner.nextInt());
            }
        }

        int i = 1;
        for (int j=1; j<=n; j++) {
            if (i >= j) {
                i = a.get(i-1).get(j-1);
            } else {
                i = a.get(j-1).get(i-1);
            }
        }
        System.out.println(i);
    }
}
