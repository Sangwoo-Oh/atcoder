import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int y = scanner.nextInt();
        if (y%4!=0) {
            System.out.println(365);return;
        }
        if (y %100!=0) {
            System.out.println(366);return;
        }
        if(y%400!=0) {
            System.out.println(365);return;
        }
        System.out.println(366);
    }
}
