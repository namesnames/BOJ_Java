import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long Ha;
    static int[][] matrix;
    static boolean check(long hp){
        long MaxHp = hp;
        boolean check = true;
        for(int r=0; r<N; r++){
            long time = 0;
            if(matrix[r][0] == 1){ // 몬스터
                if(matrix[r][2] % Ha == 0) {
                    if (matrix[r][2] / Ha == 0) time = 0; // 몫이 0일때 time이 -1되는 것을 방지
                    else time = (matrix[r][2] / Ha) - 1;
                }
                else time = matrix[r][2] / Ha;
                hp -= matrix[r][1] * time;
            }
            else{ // 포션
                Ha += matrix[r][1];
                if(hp + matrix[r][2] >= MaxHp) hp = MaxHp;
                else hp += matrix[r][2];
            }
            if(hp <= 0) {
                check = false;
                break;
            }
        }
        return check;
    }
    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //방 개수
        Ha = Long.parseLong(st.nextToken()); // 용사 공격력
        long defaultHa = Ha;

        matrix = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[i][0] = a;
            matrix[i][1] = b;
            matrix[i][2] = c;
        }

        long answer = 0;
        long start = 1;
        long end = 1_000_000_000_000_000_000L;
        while(start <= end){
            Ha = defaultHa;
            long mid = (start + end) / 2;
            if(check(mid)) {
                end = mid - 1;
                answer = mid;
            }
            else start = mid + 1;
        }
        System.out.println(answer);
    }
}
