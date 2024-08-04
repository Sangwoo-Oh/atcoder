import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String s = scanner.next();
        HashSet<String> set = new HashSet<>();

        backtrack(set, s, 0);

        System.out.println(set.size()/);
    }
}
