import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] s = new String[8];

        for (int i=0; i<8; i++) {
            s[i] = scanner.next();
        }

        int row = 0;
        int col = 0;
        for (int i=0; i<8; i++) {
            if (s[i].equals("........")) {
                row++;
            }
        }
        for (int i=0; i<8; i++) {
            boolean flag = true;
            for (int j=0; j<8; j++) {
                if (s[j].charAt(i) == '#') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                col++;
            }
        }
        System.out.println(row*col);
    }
}
