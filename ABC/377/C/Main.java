import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Set<Point> reachableCells = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            Point knight = new Point(x, y);

            reachableCells.add(knight);  // Knight's own position
            for (int j = 0; j < 8; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    reachableCells.add(new Point(nx, ny));  // Each reachable cell
                }
            }
        }

        long totalCells = (long) n * n;
        System.out.println(totalCells - reachableCells.size());
    }
}
