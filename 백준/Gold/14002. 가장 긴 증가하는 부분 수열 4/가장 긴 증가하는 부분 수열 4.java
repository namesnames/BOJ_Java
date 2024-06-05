
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            int maxNum = 0;
            for (int j = i - 1; j > 0; j--) {
                if (arr[i] > arr[j] && dp[j] > maxNum) {
                    maxNum = dp[j];
                }
            }
            dp[i] = maxNum + 1;
        }

        int idx = 1;
        int dpMax = 0;
        for (int i = 1; i < N + 1; i++) {
            if (dp[i] > dpMax) {
                idx = i;
                dpMax = dp[i];
            }
        }
        System.out.println(dpMax);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[idx]);

        int d = dp[idx] - 1;
        int val = arr[idx];
        for (int i = idx - 1; i > 0; i--) {
            if (dp[i] == d && arr[i] < val) {
                list.add(arr[i]);
                val = arr[i];
                d--;
            }
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
