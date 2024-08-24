import java.lang.*;
import java.util.*;

class Vector {
    int x, y;
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector subtract(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }

    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

	public int dot(Vector other) {
		return this.x*other.x + this.y*other.y;
	}

    public int cross(Vector v) {
        return this.x*v.y - this.y*v.x;
    }

    public int ccw(Vector v) {
        int area = this.cross(v);
        if (area>0) return 1;
        if (area<0) return -1;
        return 0;
    }

	public String toString() {
		return "("+this.x+", "+this.y+")";
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

		String[] board = new String[9];
		for (int i=0; i<9; i++) {
			board[i] = scanner.next();
		}
		List<Vector> pawns = new ArrayList<>();
        for (int y=9; y>=1; y--) {
			for (int x=1; x<=9; x++) {
				if (board[y-1].charAt(x-1)=='#') pawns.add(new Vector(x, 9-y+1));
			}
		}

		int ans = 0;
		int n = pawns.size();
		for (int i=0; i<n; i++) for (int j=0; j<n; j++) {
			for (int k=0; k<n; k++) for (int l=0; l<n; l++) {
				if (i==j || i==k || i==l || j==k || j==l || k==l) continue;
				Vector A = pawns.get(i);
				Vector B = pawns.get(j);
				Vector C = pawns.get(k);
				Vector D = pawns.get(l);

				Vector AB = B.subtract(A);
				Vector BC = C.subtract(B);
				Vector CD = D.subtract(C);
				Vector DA = A.subtract(D);

				if (AB.dot(BC)!=0 || BC.dot(CD)!=0 || CD.dot(DA)!=0 || DA.dot(AB)!=0) continue;

				// 対角線が同じ長さか　かつ　直交してるか
				Vector AC = AB.add(BC);
				Vector BD = BC.add(CD);
				if (AC.dot(AC)!=BD.dot(BD) || AC.dot(BD)!=0) continue;

				// 頂点が時計回りかどうか
				if (AB.ccw(BC)==-1 && BC.ccw(CD)==-1 && CD.ccw(DA)==-1 && DA.ccw(AB)==-1) {
					ans++;
				}
			}
		}
		System.out.println(ans/4);
    }
}
