#https://jae04099.tistory.com/entry/%EB%B0%B1%EC%A4%80-7576-%ED%86%A0%EB%A7%88%ED%86%A0-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%ED%95%B4%EC%84%A4%ED%8F%AC%ED%95%A8

from collections import deque
m,n = map(int,input().split())
matrix = [list(map(int,input().split())) for _ in range(n)]

queue = deque()

# 행렬에서 x가 움직이는 범위는 세로다... 조심
dx = [-1,1,0,0]
dy = [0,0,-1,1]

for i in range(n):
    for j in range(m):
        if(matrix[i][j] == 1):
            queue.append([i,j])
           
def bfs():
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if(0<=nx<n and 0<=ny<m and matrix[nx][ny]==0): # 범위 주의 nx는 n과 비교해야함.. 
                # 그리고 if문에서 matrix[nx][ny]==0하면 에러남.. 몰랐음 
                # 같은 if문 line이어도 nx,ny를 먼저 써줘야함
                matrix[nx][ny] = matrix[x][y] + 1 # 다음에 가볼 토마토에게는 내 숫자에다가 1을 더해서 물려줄 속셈
                                                  # 그럼 해당 토마토가 몇 번째 날에 익었는지 알 수 있음 
                queue.append([nx,ny])
bfs()
day = 0
for i in matrix:
    for j in i:
        if(j == 0):
            print(-1)
            exit(0)
    day = max(day, max(i))
print(day - 1)            
            
            