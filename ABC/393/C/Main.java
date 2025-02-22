import java.lang.*;
import java.util.*;

class Edge {
    int u;
    int v;
    Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge e = (Edge) obj;
            return (this.u == e.u && this.v == e.v) || (this.u == e.v && this.v == e.u);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.u + this.v;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int res = 0;
        HashSet<Edge> set = new HashSet<>();
        for (int i=0; i<m; i++) {
            int u = scanner.nextInt()-1;
            int v = scanner.nextInt()-1;

            // self loop
            if (u == v) {
                res++;
                continue;
            }
            if (set.contains(new Edge(u, v))) {
                res++;
            } else {
                set.add(new Edge(u, v));
            }
        }

        System.out.println(res);
    }
}
