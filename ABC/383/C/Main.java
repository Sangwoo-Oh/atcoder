import java.util.*;

public class Main {
    static int H, W, D;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力
        H = sc.nextInt();
        W = sc.nextInt();
        D = sc.nextInt();
        sc.nextLine(); // 改行消費

        grid = new char[H][W];
        visited = new boolean[H][W];
        Queue<int[]> queue = new LinkedList<>();

        // グリッド読み込み & 加湿器の位置をキューに追加
        for (int i = 0; i < H; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < W; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'H') {
                    queue.add(new int[]{i, j, 0}); // (行, 列, 距離)
                    visited[i][j] = true;
                }
            }
        }

        // BFS 開始
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // 距離がDを超えたら探索終了
            if (dist > D) continue;

            // 隣接する4方向を探索
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // グリッドの範囲内かつ未訪問かつ壁でない
                if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny] && grid[nx][ny] != '#') {
                    queue.add(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        // 加湿されている床の数を数える
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (visited[i][j] && grid[i][j] != '#') {
                    count++;
                }
            }
        }

        // 結果を出力
        System.out.println(count);
    }
}
