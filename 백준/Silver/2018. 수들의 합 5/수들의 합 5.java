
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;
        int answer = 0;

        while (left <= right && right <= N) {
            if (sum < N) {
                right++;
                sum += right;
            } else if (sum > N) {
                sum -= left;
                left++;
            } else {
                answer++;
                right++;
                sum += right;
            }
        }
        System.out.println(answer);
    }
}
