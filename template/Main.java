import java.util.*;
import java.lang.*;
import javafx.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        long N = scanner.nextLong();
        String S = scanner.nextLine();
        String S = scanner.next();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        //algorithm
        int res = 0;
        // int cnt = 0;
        // int sum = 0;
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }



        System.out.println(res);
    }
}
