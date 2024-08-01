import java.lang.*;
import java.util.*;

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x=x;this.y=y;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)return false;
        if(this == o) return true;
        if(!(o instanceof Pos)) return false;
        Pos other = (Pos)o;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x) + Objects.hash(this.y);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int h = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        HashSet<Pos> set = new HashSet<>();
        for (int i=0; i<m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            set.add(new Pos(x,y));
        }

        // R L U D
        int[] dx = new int[] {1,-1,0,0};
        int[] dy = new int[] {0,0,1,-1};

        int cx = 0;
        int cy = 0;
        for (char c : s.toCharArray()) {
            int j = 0;
            switch(c) {
                case 'R'-> {j=0;}
                case 'L'-> {j=1;}
                case 'U'-> {j=2;}
                case 'D'-> {j=3;}
            }
            cx = cx + dx[j];
            cy = cy + dy[j];
            h -= 1;

            if (h < 0) {
                System.out.println("No");
                return;
            }

            Pos now = new Pos(cx,cy);
            if (set.contains(now) && h < k) {
                h = k;
                set.remove(now);
            }
        }
        System.out.println("Yes");
    }
}
