import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // 정수 입력 후 남은 개행 문자 제거

        String str1 = "BWBWBWBW";
        String str2 = "WBWBWBWB";

        String[] pivot1 = {str1, str2, str1, str2, str1, str2, str1, str2};
        String[] pivot2 = {str2, str1, str2, str1, str2, str1, str2, str1};

        String[] adj = new String[n];
        for (int i = 0; i < n; i++) {
            adj[i] = scanner.nextLine();
        }

        int minChanges = Integer.MAX_VALUE; // 최소 변경 횟수를 저장할 변수, 최대값으로 초기화

        for (int a = 0; a <= n - 8; a++) {
            for (int b = 0; b <= m - 8; b++) {
                int cnt1 = 0;
                int cnt2 = 0;
                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 8; c++) {
                        if (adj[r + a].charAt(c + b) != pivot1[r].charAt(c)) {
                            cnt1++;
                        }
                        if (adj[r + a].charAt(c + b) != pivot2[r].charAt(c)) {
                            cnt2++;
                        }
                    }
                }
                int minval = Math.min(cnt1, cnt2);
                minChanges = Math.min(minChanges, minval);
            }
        }
        
        System.out.println(minChanges);
        
        scanner.close();
    }
}
