

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		st.nextToken()
		int n= Integer.parseInt(br.readLine());
	
		String word = br.readLine();
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0,0); //인덱스 관리를 편하게 하기위해 맨 앞에 더미데이터 추
		
		for(String s: word.split("\\s")) { //입력받은 word를 공백을 기준으로 잘라서 
			arr.add(Integer.parseInt(s)); //int로 변환한 후 arr에 저
		}
	
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			
			String temp = br.readLine();
			String[] temparr = temp.split("\\s");
			int a = Integer.parseInt(temparr[0]);
			int b = Integer.parseInt(temparr[1]);
			
			if(a == 1) {
				for(int t=1; t*b < n+1; t++) { //남자니까 배수만큼 for loop
					if(arr.get(t*b) == 0) { //0이
						arr.set(t*b,1); //1로 바꿔주
					}else {             //1이
						arr.set(t*b, 0); //0으로 바꿔
					}
				}
			}
			
			else if(a == 2) {
				
				if(arr.get(b) == 0) { //일단 b인덱스 위치부터 스위
					arr.set(b, 1);
				}else { 
					arr.set(b, 0);}
				
				for(int p=1; p<n; p++) { //좌우대칭 확인 
					if(b-p <1 || b+p>n ||(arr.get(b-p) != arr.get(b+p))) { //인덱스범위가 벗어나면 break
						break;
					}
					else {
						if(arr.get(b-p) == arr.get(b+p)) { //좌우대칭이면
							if(arr.get(b-p) == 0) { //왼쪽부터 스위
								arr.set(b-p, 1);
							}
							else {
								arr.set(b-p, 0);
							}
							//오른쪽스위칭 
							if(arr.get(b+p) == 0) { 
								arr.set(b+p, 1);
							}
							else {
								arr.set(b+p, 0);
							}
							
						}
					}
				}
								
			}
		}
	
	
		
	arr.remove(0);
	int cnt = 0;
	for(int i=0; i<arr.size(); i++) {
		
		cnt++;
		System.out.print(arr.get(i));
		System.out.print(" ");
		if(cnt % 20 ==0) {
			System.out.println();
		}
	   }
	}
}

