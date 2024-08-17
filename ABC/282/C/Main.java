import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String s = scanner.next();

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            char cur = s.charAt(i);
            if (cur == '"') flag = flag ? false : true;
            if (!flag && cur == ',') {
                sb.append('.');
            } else {
                sb.append(cur);
            }
        }
        System.out.println(sb.toString());
    }
}
