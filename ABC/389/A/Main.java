import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();

        int a = Integer.parseInt(String.valueOf(s.charAt(0)));
        int b = Integer.parseInt(String.valueOf(s.charAt(2)));

        System.out.println(a*b);
    }
}
