import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] matrix = new long[N+1][10];
        for(int i=0; i<10; i++){
            matrix[0][i] = 1;
        }
        for(int r=1; r<N+1; r++){
            for(int i=0; i<10; i++){
                for(int j=i; j<10; j++){
                    matrix[r][i] = (matrix[r][i] + matrix[r-1][j]) % 10007;
                }
            }
        }
        System.out.println(matrix[N][0]);
    }
}