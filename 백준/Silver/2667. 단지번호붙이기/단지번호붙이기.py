from collections import deque
import sys
N = int(input())

dr = [0,0,-1,1]
dc = [1,-1,0,0]

def bfs(a,b):
    global cnt
    global matrix
    dq = deque()
    dq.append([a,b])
    matrix[a][b] = 0
    
    while dq:
        r,c = dq.popleft()
        cnt += 1
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if(0<=nr<N and 0<=nc<N and matrix[nr][nc] == 1):
                dq.append([nr,nc])
                matrix[nr][nc] = 0
    return cnt
    
matrix = []
for _ in range(N):
    matrix.append(list(map(int,sys.stdin.readline().strip())))


danzi = 0    
cntList = []
for r in range(N):
    for c in range(N):
        if(matrix[r][c] == 1):
            cnt = 0
            cntList.append(bfs(r,c))
            danzi += 1
            
print(danzi)
for k in sorted(cntList):
    print(k)