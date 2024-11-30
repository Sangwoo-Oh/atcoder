import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        String str = "";
        for (int i=s.length()-1; i>s.length()-1-3; i--) {
            str += s.charAt(i);
        }
        System.out.println(str.equals("nas") ? "Yes" : "No");
    }
}
