
import java.util.*;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int R = scanner.nextInt();

            int[][] matrix = new int[N][M];
            int[][] answer = new int[N][M];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }

            ArrayList<Integer> dq = new ArrayList<>();

            int l = Math.min(M, N);

            for (int i = 0; i < l / 2; i++) {
                for (int c = i; c < M - i; c++) {
                    dq.add(matrix[i][c]);
                }

                for (int r = i; r < N - i; r++) {
                    if (r != i) {
                        dq.add(matrix[r][M - i - 1]);
                    }
                }

                for (int c = M - i - 1; c > i; c--) {
                    if (c != M - i - 1) {
                        dq.add(matrix[N - i - 1][c]);
                    }
                }

                for (int r = N - i - 1; r > i; r--) {
                    if (r != N - i - 1 || r != i - 1) {
                        dq.add(matrix[r][i]);
                    }
                }

                Collections.rotate(dq, -R);


                // 껍질 깎았던 방법 그대로 정답에 채워넣기

                    for (int c = i; c < M - i; c++) {
                        answer[i][c] = dq.get(0);
                        dq.remove(0);
                    }

                    for (int r = i; r < N - i; r++) {
                        if (r != i) {
                            answer[r][M - i - 1] = dq.get(0);
                            dq.remove(0);
                        }
                    }

                    for (int c = M - i - 1; c > i; c--) {
                        if (c != M - i - 1) {
                            answer[N - i - 1][c] = dq.get(0);
                            dq.remove(0);
                        }
                    }

                    for (int r = N - i - 1; r > i; r--) {
                        if (r != N - i - 1 || r != i - 1) {
                            answer[r][i] = dq.get(0);
                            dq.remove(0);
                        }
                    }

            }

            for (int[] row : answer) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

    }
}
