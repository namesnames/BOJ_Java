

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<int[]> list = new ArrayList<>(); //arrayList에 [신맛,쓴맛의 차] 넣을 예정
        ArrayList<Integer> answer = new ArrayList<>(); //정답 후보를 넣은 arrayList

        int N = Integer.parseInt(st.nextToken());
        for(int t=0; t<N; t++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                list.add(new int[] {A,B}); // arrayList에 음식의 신맛,쓴맛을 리스트로 묶어서 같이 넣어줌
        }

        int CaseNum = 1<<N; //경우의 수
        for(int i=1; i<CaseNum; i++){ //0000은 제외
            int sour= 1, bitter = 0;
            for(int j=0; j<N; j++){ //N이 4라면 각 경우(16가지)에 대해서 네칸씩 다 스캔하는 것
                if((i & 1<<j) >0){ // 스캔하는데 그 칸이 1이면
                    sour *= list.get(j)[0]; //list의 j번째 인덱스의 첫 번째 원소(신맛)
                    bitter += list.get(j)[1]; //list의 j번째 인덱스의 두 번째 원소(쓴맛)
                }
            }
            //한 경우에 대해 스캔 한 번 끝나면 바로 신맛과 쓴맛 차이를 기록
            answer.add(Math.abs(sour-bitter));
        }
        sb.append(Collections.min(answer)); //정답 후보 중 최소를 StringBuild에 저장
        System.out.println(sb); //최종출력

    }
}
