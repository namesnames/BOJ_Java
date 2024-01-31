// Java

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] matrix = new int[N][M];
        int[][] visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<int[]> dq = new ArrayDeque<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (matrix[r][c] == 1) {
                    visited[r][c] = 1;
                    dq.add(new int[]{r, c});
                }
                if (matrix[r][c] == -1) {
                    visited[r][c] = -1;
                }
            }
        }

        bfs(dq, visited, dr, dc, N, M);

        int[] li = new int[N];
        for (int r = 0; r < N; r++) {
            if (containsZero(visited[r])) {
                System.out.println(-1);
                System.exit(0);
            }
            li[r] = getMax(visited[r]);
        }

        System.out.println(getMax(li) - 1);
    }

    public static void bfs(Queue<int[]> dq, int[][] visited, int[] dr, int[] dc, int N, int M) {
        while (!dq.isEmpty()) {
            int[] rc = dq.poll();
            int r = rc[0];
            int c = rc[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[r][c] + 1;
                    dq.add(new int[]{nr, nc});
                }
            }
        }
    }

    public static boolean containsZero(int[] arr) {
        for (int value : arr) {
            if (value == 0) {
                return true;
            }
        }
        return false;
    }

    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}