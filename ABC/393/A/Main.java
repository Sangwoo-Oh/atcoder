import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s1 = scanner.next();
        String s2 = scanner.next();

        if (s1.equals("sick") && s2.equals("sick")) {
            System.out.println("1");
        } else if (s1.equals("sick") && s2.equals("fine")) {
            System.out.println("2");
        } else if (s1.equals("fine") && s2.equals("sick")) {
            System.out.println("3");
        } else {
            System.out.println("4");
        }
    }
}
