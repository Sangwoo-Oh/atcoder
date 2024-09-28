import java.util.*;

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public int find(int x) {
        if (parent[x] < 0) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            if (parent[xRoot] > parent[yRoot]) {
                int temp = xRoot;
                xRoot = yRoot;
                yRoot = temp;
            }
            parent[xRoot] += parent[yRoot];
            parent[yRoot] = xRoot;
        }
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int H = sc.nextInt();
        int W = sc.nextInt();
        int Q = sc.nextInt();
        
        int[][] queries = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            queries[i][0] = sc.nextInt() - 1;  // Rq
            queries[i][1] = sc.nextInt() - 1;  // Cq
        }
        
        // UnionFindによる壁の管理
        UnionFind uf = new UnionFind(H * W);
        
        // 壁の状態を管理する配列
        boolean[][] hasWall = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(hasWall[i], true);
        }
        
        // クエリを処理
        for (int[] query : queries) {
            int r = query[0];
            int c = query[1];
            
            if (hasWall[r][c]) {
                // その場所に壁があれば破壊
                hasWall[r][c] = false;
            } else {
                // 壁がない場合、上下左右の壁を探して破壊する
                int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
                
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && hasWall[nr][nc]) {
                        hasWall[nr][nc] = false;
                        break;
                    }
                }
            }
        }
        
        // 残っている壁の数をカウント
        int remainingWalls = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (hasWall[i][j]) {
                    remainingWalls++;
                }
            }
        }
        
        System.out.println(remainingWalls);
    }
}
