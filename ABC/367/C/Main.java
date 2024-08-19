import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) sb.append(1);
        int start = Integer.parseInt(sb.toString());

        int[] r = new int[n];
        sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            r[i] = scanner.nextInt();
            sb.append(r[i]);
        }
        int end = Integer.parseInt(sb.toString());

        for (int i=start; i<=end; i++) {
            int sum = 0;
            int x = i;
            boolean isValid = true;
            for (int j=0; j<n; j++) {
                int digit = x % 10;
                if (digit > r[n-j-1] || digit == 0) {
                    isValid = false;
                    break;
                }
                sum += digit;
                x /= 10;
            }
            if(!isValid) continue;

            if (sum % k == 0) {
                StringBuilder s = new StringBuilder();
                String num = s.append(i).toString();
                int len = num.length();
                int j=1;
                for (char c : num.toCharArray()) {
                    System.out.print(c);
                    if (j!=len) System.out.print(" ");
                    else System.out.println();
                    j++;
                }
            }
        }
    }
}
