import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int cnt = 0;
        int exist = 0;

        while (true) {
            boolean flag = false;

            if (matrix[r][c] == 1) {
                break;
            } else if (matrix[r][c] == 0) {
                matrix[r][c] = 2; // 현재 위치 청소
                cnt++;
            }

            exist = 0;

            // 이제 주변을 봐야하는데 일단 90도로 돌아
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && matrix[nr][nc] == 0) {
                    exist++;
                }
            }

            if (exist > 0) {
                while (true) {
                    d = (d + 3) % 4; // 방향돌리기
                    int ngr = r + dr[d]; // 현재 위치에서 방향돌려서
                    int ngc = c + dc[d]; // 앞으로 전진
                    if (0 <= ngr && ngr < N && 0 <= ngc && ngc < M && matrix[ngr][ngc] == 0) { // 가보려 했더니 갈 수 있으면 여기서 멈추고 진행
                        r = ngr;
                        c = ngc;
                        flag = true;
                        break;
                    }
                }
            }

            // for문에 들어가지 못했다면 후진할 차례
            if (!flag) {
                int s = (d + 2) % 4;
                r = r + dr[s];
                c = c + dc[s];
            }
        }

        System.out.println(cnt);
    }
}
