import java.io.*;
import java.util.*;

// 민서가 진행할 연산 수 = 싸이클 갯수 + (그룹 갯수-1)
// 그룹 개수가 2개면 연결 선은 1개만 있으며 되니까
// 입력으로 들어오는 두 정점을 유니온 연산으로 하나의 집합으로 형성해주고
// find했을 때 root가 같으면 cycle개수를 늘려주면 됨

public class Main {
    static int[] parent;

    static void union(int r1, int r2){
        if(parent[r1] < parent[r2]){ // parent[r1]이 -5라면, 이는 r1이 root이며 그 집합의 크기가 5임을 의미함
            parent[r1] += parent[r2];
            parent[r2] = r1; // r2의 부모는 r1이다
        }
        else{  //맨 처음 정점이 3 5가 들어오면 두 번째인 5를 root로 하기로 설정(첫 번째로 해도 노상관)
               // 두 그룹을 합칠 땐 더 큰 그룹이 root가 되도록 함
            parent[r2] += parent[r1];
            parent[r1] = r2;
        }
    }

    static int find(int r){
        if(parent[r] < 0) return r;

        parent[r] = find(parent[r]); //좌표 압축
        return parent[r];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        Arrays.fill(parent, -1);

        int cycle = 0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int r1 = find(u); // 부모 찾기
            int r2 = find(v);

            if(r1 == r2){ // 부모가 같으면 싸이클
                cycle++;
                continue;
            }
            union(r1,r2);
        }

        int root = 0;
        for(int i=1; i<N+1; i++){
            if(parent[i] < 0) root++;
        }
        System.out.println(cycle + root - 1);
    }
}