package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point_15683 {
    int x;
    int y;

    Point_15683(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_15683 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int l = Integer.parseInt(s1[1]);
        int r = Integer.parseInt(s1[2]);

        int[][] country = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                country[i][j] = Integer.parseInt(s2[j]);
            }
        }

        int ans = 0;
        while (true) {
            boolean[][] check = new boolean[n][n];
            boolean stop = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!check[i][j]) {
                        boolean ok = bfs(country, check, i, j, n, l, r);
                        if (ok) stop = false;
                    }
                }
            }
            if (!stop) ans++;
            else break;
        }
        System.out.println(ans);
    }

    private static boolean bfs(int[][] country, boolean[][] check, int x, int y, int n, int l, int r) {
        Queue<Point_15683> queue = new LinkedList<>();
        Queue<Point_15683> sumQueue = new LinkedList<>();
        int sum = 0;
        queue.add(new Point_15683(x, y));
        check[x][y] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Point_15683 p = queue.poll();
            sumQueue.add(p);
            sum += country[p.x][p.y];
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int dif = Math.abs(country[p.x][p.y] - country[nx][ny]);
                    if (!check[nx][ny] && dif >= l && dif <= r) {
                        queue.add(new Point_15683(nx, ny));
                        check[nx][ny] = true;
                    }
                }
            }
        }
        if (sumQueue.size() == 1) return false;
        int add = sum / sumQueue.size();
        while (!sumQueue.isEmpty()) {
            Point_15683 p = sumQueue.poll();
            country[p.x][p.y] = add;
        }
        return true;
    }
}
