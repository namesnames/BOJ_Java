import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] sum = new long[n];
        long[] cnt = new long[4];
        cnt[0] = 1;
        
        long s = 0;
        long division;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long input = Long.parseLong(st.nextToken());
            s += input;
            sum[i] = s;
        }

        if (sum[n - 1] % 4 != 0) {
            System.out.println(0);
        } else {
            division = sum[n - 1] / 4;
            for (int i = 0; i < n - 1; i++) {
                if (sum[i] == 3 * division) {
                    cnt[3] += cnt[2];
                }
                if (sum[i] == 2 * division) {
                    cnt[2] += cnt[1];
                }
                if (sum[i] == 1 * division) {
                    cnt[1] += cnt[0];
                }
            }
            System.out.println(cnt[3]);
        }
    }
}
