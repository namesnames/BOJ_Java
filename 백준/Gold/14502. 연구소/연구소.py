from collections import deque
import copy

N, M = map(int,input().split())

dr = [0,-1,0,1]
dc = [1,0,-1,0]



# 벽 3개 세울 때마다 진행해야 하므로 매번 matrix복제해서 새로 진행
def bfs():
    dq = deque()
    for i in range(N):
        for j in range(M):
            if(matrix[i][j] == 2):
                dq.append([i,j])

    temp_matrix = copy.deepcopy(matrix)
    while(dq):
        r,c = dq.popleft()
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if(0<=nr<N and 0<=nc<M and temp_matrix[nr][nc] == 0):
                temp_matrix[nr][nc] = 2
                dq.append([nr,nc])

    global answer
    cnt = 0
    for r in range(N):
        for c in range(M):
            if(temp_matrix[r][c] == 0):
                cnt += 1
    answer = max(answer,cnt)

def wall(depth):
    if(depth == 3):
        bfs() # 바이러스 확산 시작
        return
    
    for i in range(N):
        for j in range(M):
            if(matrix[i][j] == 0):
                matrix[i][j] = 1 # 벽을 세운다
                wall(depth+1)
                matrix[i][j] = 0  #벽을 허문다


matrix = []
for _ in range(N):
    matrix.append(list(map(int,input().split())))
    
answer = 0
wall(0)
print(answer)