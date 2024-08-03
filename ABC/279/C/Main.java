import java.lang.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int h = scanner.nextInt();
		int w = scanner.nextInt();
		char[][] s = new char[w][h];
		char[][] t = new char[w][h];
		for (int i=0; i<h; i++) {
			String str = scanner.next();
			for (int j=0; j<w; j++) {
				s[j][i]=str.charAt(j);
			}
		}
		for (int i=0; i<h; i++) {
			String str = scanner.next();
			for (int j=0; j<w; j++) {
				t[j][i]=str.charAt(j);
			}
		}

		String[] sStr = new String[w];
		String[] tStr = new String[w];
		for (int i=0; i<w; i++) {
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			for (int j=0; j<h; j++) {
				sb1.append(s[i][j]);
				sb2.append(t[i][j]);
			}
			sStr[i] = sb1.toString();
			tStr[i] = sb2.toString();
		}

		Arrays.sort(sStr);
		Arrays.sort(tStr);

		for (int i=0; i<w; i++) {
			if (!sStr[i].equals(tStr[i])) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}
}
