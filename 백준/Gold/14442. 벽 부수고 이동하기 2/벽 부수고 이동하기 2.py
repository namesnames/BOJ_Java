from collections import deque
import sys
input = sys.stdin.readline

dr = [0,-1,0,1]
dc = [1,0,-1,0]

N,M,K = map(int,input().rstrip().split())
visited = [[[0]*(K+1) for _ in range(M)] for _ in range(N)]
matrix = []

for _ in range(N):
    matrix.append(list(map(int,input().rstrip())))

dq = deque()
dq.append([0,0,K])
visited[0][0][K] = 1

def bfs():
    while(dq):
        r,c,k = dq.popleft()
        if(r == N-1 and c == M-1):
            return k
        
        if(k > 0):
            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]
                if(0<=nr<N and 0<=nc<M and visited[nr][nc][k-1] == 0 and matrix[nr][nc] == 1):
                    visited[nr][nc][k-1] = visited[r][c][k] + 1
                    dq.append([nr,nc,k-1])

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if(0<=nr<N and 0<=nc<M and visited[nr][nc][k] == 0 and matrix[nr][nc] == 0):
                visited[nr][nc][k] = visited[r][c][k] + 1
                dq.append([nr,nc,k])
    return -1

b = bfs()
if(b == -1):
    print(-1)
else:
    print(visited[N-1][M-1][b])
