import java.lang.*;
import java.util.*;

class Edge {
    int to;
    int cost;
    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String s = scanner.next();

        ArrayList<int[]> graph = new ArrayList<>();
        int prev = -1;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '1') {
            }
        }
    }
}
