import java.io.*;
import java.util.*;
// https://www.acmicpc.net/source/81934797 // 이 분 코드 대박
// 오르막일 때 cnt는 생각했는데 내리막일 때는 못할 거라 생각했음
// 근데 이 분은 내리막일 때 cnt를 음수로 두고 그냥 했네..

// 내 풀이 right방향으로 한 번, left방향으로 한 번 쓸어가며 오르막일 때만 봄 
public class Main {
    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] colV = new int[N][N];
        int L;
        int answer = 0;
        for(int r=0; r<N; r++){
            int c = 0;
            boolean flag = true;
            while(c < N-1){
                if(matrix[r][c] - matrix[r][c+1] > 1){
                    flag = false;
                    break;
                }
                if(matrix[r][c] - matrix[r][c+1] == 1){ // 1차이나는 내리막이면
                    int target = matrix[r][c+1];
                    L = len;
                    while(L > 0) {
                        c++;
                        if (c == N) {
                            flag = false;
                            break;
                        }
                        if (matrix[r][c] == target) {
                            colV[r][c] = 1; // 경사로 설치
                        } else {
                            flag = false;
                            break;
                        }
                        L--;
                    }
                }
                else c++; //오르막길이면 일단 패스

            }
            c = N-1;
            while(c > 0){
                if(matrix[r][c] - matrix[r][c-1] > 1){
                    flag = false;
                    break;
                }
                if(matrix[r][c] - matrix[r][c-1] == 1){
                    int target = matrix[r][c-1];
                    L = len;
                    while(L > 0){
                        c--;
                        if(c == -1) {
                            flag = false;
                            break;
                        }
                        if(matrix[r][c] == target){
                            if(colV[r][c] == 1){
                                flag = false;
                                break;
                            }
                            else{
                                colV[r][c] = 1;
                            }
                        }
                        else{
                            flag = false;
                            break;
                        }
                        L--;
                    }
                }
                else c--;
            }
            if(flag) answer++;
        }

        int[][] rowV = new int[N][N];
        for(int c=0; c<N; c++){
            int r = 0;
            boolean flag = true;
            while(r < N-1){
                if(matrix[r][c] - matrix[r+1][c] > 1){
                    flag = false;
                    break;
                }
                if(matrix[r][c] - matrix[r+1][c] == 1){ // 1차이나는 내리막이면
                    int target = matrix[r+1][c];
                    L = len;
                    while(L > 0) {
                        r++;
                        if (r == N) {
                            flag = false;
                            break;
                        }
                        if (matrix[r][c] == target) {
                            rowV[r][c] = 1; // 경사로 설치
                        } else {
                            flag = false;
                            break;
                        }
                        L--;
                    }
                }
                else r++; //오르막길이면 일단 패스
            }
            
            r = N-1;
            while(r > 0){
                if(matrix[r][c] - matrix[r-1][c] > 1){
                    flag = false;
                    break;
                }
                if(matrix[r][c] - matrix[r-1][c] == 1){
                    int target = matrix[r-1][c];
                    L = len;
                    while(L > 0){
                        r--;
                        if(r == -1) {
                            flag = false;
                            break;
                        }
                        if(matrix[r][c] == target){
                            if(rowV[r][c] == 1){
                                flag = false;
                                break;
                            }
                        }
                        else{
                            flag = false;
                            break;
                        }
                        L--;
                    }
                }
                else r--;
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }
}
