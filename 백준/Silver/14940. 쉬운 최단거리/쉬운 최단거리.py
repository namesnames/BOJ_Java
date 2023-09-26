import sys
input = sys.stdin.readline
from collections import deque

n,m = map(int,input().strip().split())

dr = [0,-1,0,1]
dc = [-1,0,1,0]

matrix = [[0 for _ in range(m)] for _ in range(n)]
visited = [[0 for _ in range(m)] for _ in range(n)]
r = 0
c = 0

def bfs():
    while dq:
        i,j = dq.popleft()
        for next in range(4):
            nr = i + dr[next]
            nc = j + dc[next]
            if(0<=nr<n and 0<=nc<m and visited[nr][nc] == 0 and matrix[nr][nc] == 1):
                dq.append([nr,nc])
                visited[nr][nc] = visited[i][j] + 1
                
dq = deque()
for i in range(n):
    matrix[i] = list(map(int,input().strip().split()))
    if(2 in matrix[i]):
        r = i
        c = matrix[i].index(2)
        dq.append([r,c])

bfs()

for a in range(n):
    for b in range(m):
        if(matrix[a][b] == 1 and visited[a][b] == 0):
            visited[a][b] = -1
            
for x in visited:
    print(*x)