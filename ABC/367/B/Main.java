import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        double x = scanner.nextDouble();
        int y = (int)x;
        if (x - y == 0) {
            System.out.println(y);
            return;
        }
        System.out.println(x);
    }
}
