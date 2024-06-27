import java.io.*;
import java.util.*;

// n-1개를 중앙으로 옮기고
// 제일 밑 판을 끝으로 옮기고
// 마지막으로 n-1을 끝으로 옮기는 로직
// https://www.youtube.com/watch?v=AogMbfRwguk (이해 잘 됨)

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void move(int n, int from, int to){
        int mid = 6 - from - to; // mid를 if문 6개로 해도 되지만 이렇게 간략화할 수 있음

        if(n == 1){
            sb.append(from).append(" ").append(to).append("\n");
        }

        if(n >= 2){ // 일단 원판이 2개일 때 써 본 함수이고 그 2개 이상일때도 되는지 스근하게 체크
            move(n-1, from, mid); // n-1개를 중앙으로
            move(1, from, to); // 제일 밑 판
            move(n-1, mid, to); // n-1개를 중앙에서 끝으로
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2,N) - 1).append("\n");
        move(N,1,3);
        System.out.println(sb);
    }
}
