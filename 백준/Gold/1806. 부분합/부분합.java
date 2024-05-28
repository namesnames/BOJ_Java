import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N = 0;
    static int S = 0;
    static int[] arr;

    public static boolean check(int mid) {
        int sum = 0;
        // 첫 부분합 계산
        for (int i = 0; i < mid; i++) {
            sum += arr[i];
        }
        if (sum >= S) return true;
        // 슬라이딩 윈도우
        for (int i = mid; i < N; i++) {
            sum += arr[i] - arr[i - mid];
            if (sum >= S) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1; // 최소 길이는 1
        int end = N; // 최대 길이는 N
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) { // 가능하면
                result = mid; // 현재 길이를 저장하고
                end = mid - 1; // 더 짧은 길이를 시도
            } else {
                start = mid + 1; // 불가능하면 더 긴 길이를 시도
            }
        }

        if (result == 0) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
