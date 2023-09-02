from collections import deque 
N,M = map(int,input().split())

dr = [0,0,-1,1]
dc = [1,-1,0,0]

def bfs():
    while dq:
        r,c = dq.popleft()
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if(0<=nr<N and 0<=nc<M and matrix[nr][nc] == 1):
                dq.append([nr,nc])
                matrix[nr][nc] = matrix[r][c] + 1  # 어차피 먼저 도달한 것이 최소임 # 큐에서 먼저 빠지니까
    
matrix = []
for _ in range(N):
    matrix.append(list(map(int,input())))
    
dq = deque()
dq.append([0,0])
bfs()

print(matrix[N-1][M-1])