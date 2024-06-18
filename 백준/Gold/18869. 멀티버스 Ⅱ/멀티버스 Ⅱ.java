import java.io.*;
import java.util.*;

// 좌표압축 -> 큰 범위의 수들을 대소관계만 파악하기 위해 순위만 메기는 것
// 일단 배열은 set로 받고, 이 new ArrayList<>(set)를 통해 set를 list로 바꿔줌
// Collections.binarySearch(리스트,원하는 값) -> 해당 리스트에서 몇 번째 인덱스에 있는지 반환 // O(logN)
// Arrays.equals(arr1, arr2) -> 두 배열이 같은지 확인해줌 // O(N)

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[M][N];
        List<Integer>[] list = new ArrayList[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                set.add(num);
            }
            list[i] = new ArrayList<>(set);  // set의 모든 요소를 새로운 ArrayList로 복사하여 list의 i번째 인덱스에 할당하는 것
            Collections.sort(list[i]);

            for(int j=0; j<N; j++){
                matrix[i][j] = Collections.binarySearch(list[i], matrix[i][j]);
            }
        }

        int cnt = 0;
        for(int r=0; r<M-1; r++){
            for(int nr=r+1; nr<M; nr++){
                if(Arrays.equals(matrix[r], matrix[nr])) cnt++;
            }
        }
        System.out.println(cnt);
    }
}