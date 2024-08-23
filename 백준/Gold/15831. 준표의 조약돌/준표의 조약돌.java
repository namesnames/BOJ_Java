import java.io.*;
import java.util.*;


public class Main {

    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = (str.charAt(i) == 'W') ? 1 : 0;
        }

        int[] rock = new int[2]; // 0인덱스는 B, 1인덱스는 W
        int length = 0;
        int left = 0;
        int right = 0;

        while (right < N) {
            rock[arr[right]]++;

            while (rock[0] > B) { // B의 개수가 초과하면 left를 이동
                rock[arr[left]]--;
                left++;
            }

            if (rock[1] >= W) { // W의 개수가 조건을 만족할 때만 길이 갱신
                length = Math.max(length, right - left + 1);
            }

            right++;
        }

        System.out.println(length);
    }
}
