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

        /* input */
        ArrayList<V> p = new ArrayList<>();
        for (int i=0; i<4; i++) {
            p.add(new V(scanner.nextInt(), scanner.nextInt()));
        }
        for (int i=0; i<4; i++) {
            V A = p.get(i);
            V B = p.get((i+1)%4);
            V C = p.get((i+2)%4);
            V b = B.subtract(A), c = C.subtract(A);
            if (b.ccw(c)!=1) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
