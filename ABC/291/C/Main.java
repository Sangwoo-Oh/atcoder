import java.lang.*;
import java.util.*;

class Pos {
    int x;
    int y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Pos) {
            Pos p = (Pos) obj;
            return this.x == p.x && this.y == p.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String s = scanner.next();

        Set<Pos> set = new HashSet<>();
        Pos now = new Pos(0, 0);
        set.add(now);
        for (int i=0; i<n; i++) {
            Pos next = new Pos(now.x, now.y);
            if (s.charAt(i) == 'U') {
                next.y++;
            } else if (s.charAt(i) == 'D') {
                next.y--;
            } else if (s.charAt(i) == 'L') {
                next.x--;
            } else if (s.charAt(i) == 'R') {
                next.x++;
            }
            if (set.contains(next)) {
                System.out.println("Yes");
                return;
            }
            set.add(next);
            now = next;
        }
        System.out.println("No");
    }
}
