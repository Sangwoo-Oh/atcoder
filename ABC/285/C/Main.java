import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
		int n = s.length();

		long rank = 0;
		for (int i = n-1; i >= 0; i--) {
			long pow = 1;
			int k = i;
			while (k > 0) {
				pow *= 26;
				k--;
			}
			rank += pow * ((int)(s.charAt(n-i-1) - 'A')+1);
		}

		System.out.println(rank);
    }
}
