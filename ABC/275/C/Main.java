import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* input */
		char[][] field = new char[9][9];
        for (int i=0; i<9; i++) {
			String s = scanner.next();
			for (int j=0; j<9; j++)	field[i][j] = s.charAt(j);
		}

		int[] a = new int[2], b = new int[2], c = new int[2], d = new int[2];
		int ans = 0;
		for (int i=0; i<9; i++) for (int j=0; j<9; j++) {
			if (field[i][j]=='#') {
				a[0]=i; a[1]=j;
				int cnt = 1;
				for (int k=i; k<9; k++) for (int l=0; l<9; l++) {
					if (k==i && l==0) l=j+1;
					if (cnt < 4 && field[k][l]=='#') {
						if (cnt==1) {
							b[0]=k; b[1]=l;
							cnt++;
						} else if (cnt==2){
							c[0]=k; c[1]=l;
							cnt++;
						} else if (cnt==3){
							d[0]=k; d[1]=l;
							cnt++;
						}
					}
				}

				System.out.println(a[0] + " " + a[1]);
				System.out.println(b[0] + " " + b[1]);
				System.out.println(c[0] + " " + c[1]);
				System.out.println(d[0] + " " + d[1]);

				if (cnt < 4) continue;
				if (judge(a,b,c,d)) {
					ans++;
				}
			}
		}
		System.out.println(ans);
    }

	static public boolean judge(int[] a, int[] b, int[] c, int[] d) {
		int ab = Math.abs(a[0]-b[0])*Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1])*Math.abs(a[1]-b[1]);
		int ac = Math.abs(a[0]-c[0])*Math.abs(a[0]-c[0]) + Math.abs(a[1]-c[1])*Math.abs(a[1]-c[1]);
		int bd = Math.abs(b[0]-d[0])*Math.abs(b[0]-d[0]) + Math.abs(b[1]-d[1])*Math.abs(b[1]-d[1]);
		int cd = Math.abs(c[0]-d[0])*Math.abs(c[0]-d[0]) + Math.abs(c[1]-d[1])*Math.abs(c[1]-d[1]);
		if (ab==ac && bd==cd && ab==bd) return true;
		return false;
	}
}
