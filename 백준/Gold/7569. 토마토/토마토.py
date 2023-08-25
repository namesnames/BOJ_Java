from collections import deque
m,n,h = map(int,input().split())
matrix = [[list(map(int,input().split())) for _ in range(n)] for _ in range(h)]

queue = deque()

for i in range(h):
    for j in range(n):
        for k in range(m):
            if (matrix[i][j][k] == 1):
                queue.append([i,j,k])

dx = [-1,1,0,0,0,0]
dy = [0,0,1,-1,0,0]
dz = [0,0,0,0,1,-1]
def bfs():
    while queue:
        z,x,y = queue.popleft()
        for i in range(6):
            nz = z + dz[i]
            nx = x + dx[i]
            ny = y + dy[i]
            if(0<=nz<h and 0<=nx<n and 0<=ny<m and matrix[nz][nx][ny]==0):
                matrix[nz][nx][ny] = matrix[z][x][y] + 1
                queue.append([nz,nx,ny])
day = 0
bfs()

for i in matrix:
    for j in i:
        for k in j:
            if(k == 0):
                print(-1)
                exit(0)
        day = max(day,max(j))
print(day - 1)