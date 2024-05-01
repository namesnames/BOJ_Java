import sys
from collections import deque
input = sys.stdin.readline

dr = [0,-1,0,1]
dc = [1,0,-1,0]

def bfs():
    while dq:
        r,c,k = dq.popleft()
        if(r == N-1 and c == M-1):
            return visited[r][c][k]+1

        if(k > 0):
            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]
                if(0<=nr<N and 0<=nc<M and visited[nr][nc][k] == 0 and matrix[nr][nc] == 1):
                    visited[nr][nc][k-1] = visited[r][c][k] + 1
                    dq.append([nr,nc,k-1])
        
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if(0<=nr<N and 0<=nc<M and visited[nr][nc][k] == 0 and matrix[nr][nc] == 0):
                visited[nr][nc][k] = visited[r][c][k] + 1
                dq.append([nr,nc,k])
    
    return -1

N,M = map(int,input().rstrip().split())
matrix = []
for _ in range(N):
    matrix.append(list(map(int,input().rstrip())))

visited = [[[0]* 2 for _ in range(M)]for _ in range(N)]
dq = deque()
dq.append([0,0,1])

print(bfs())