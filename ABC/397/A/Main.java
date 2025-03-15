import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        float x = scanner.nextFloat();
        if (x >= 38.0f) {
            System.out.println(1);
        } else if (x >= 37.5f && x < 38.0f) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}
