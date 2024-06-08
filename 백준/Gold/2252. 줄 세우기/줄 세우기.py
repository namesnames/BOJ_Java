#위상정렬 알고리즘
# https://www.youtube.com/watch?v=xeSz3pROPS8  3분50초부터 그림설명 굳
# https://velog.io/@ledcost/%EB%B0%B1%EC%A4%80-2252-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EC%A4%84-%EC%84%B8%EC%9A%B0%EA%B8%B0-%EA%B3%A8%EB%93%9C-3-%EC%9C%84%EC%83%81-%EC%A0%95%EB%A0%AC 블로그 설명


import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().split())
matrix = [[] for _ in range(N+1)] 
inDegree = [0]*(N+1) # 진입차수를 나타내는 리스트

for _ in range(M):  # 진입 차수를 기록하는 과정
    A,B = map(int,input().split())
    matrix[A].append(B)  # A에서 B방향이라는 것을 기록
    inDegree[B] += 1 # B는 진입차수 1 증가

q = deque()

for s in range(1,N+1): 
    if(inDegree[s] == 0): #최초에 진입차수가 0인 노드들을 큐에 넣는다 #위상정렬 기본 로직이다
        q.append(s) #진입차수가 없다는 것은 줄세웠을 때 맨 앞쪽이라는 것이니까

ans = []

while q: # queue가 빌 때까지 반복
    s = q.popleft() #진입차수 없던 녀석들부터 빼면서 진행
    ans.append(s)# 동시에 앞 순번이니 답에 넣고

    for adj_s in matrix[s]: #그 뺀 녀석이 바라보는 녀석들에 대해서 진행
        inDegree[adj_s] -= 1 # 큐에서 뺌과 동시에 아예 삭제 # 삭제하면 날 바라보던 녀석이 사라졌으니 진입차수가 1감소
        if(inDegree[adj_s] == 0): # 이 때 진입차수가 0이 됐다?
            q.append(adj_s) # 너도 큐에 들어가

print(*ans, sep=" ")            
        