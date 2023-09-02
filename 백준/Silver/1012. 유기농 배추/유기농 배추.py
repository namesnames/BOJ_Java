from collections import deque
import sys

T = int(input())

dr = [0,0,-1,1]
dc = [1,-1,0,0]

def bfs(x,y):
    dq = deque()
    dq.append([x,y])
    matrix[x][y] = 0
    
    while dq:
        r,c = dq.popleft()
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if(0<=nr<n and 0<=nc<m and matrix[nr][nc] == 1):
                dq.append([nr,nc])
                matrix[nr][nc] = 0
   
        
for _ in range(T):
    m,n,k = map(int,input().split())
    matrix = [[0 for _ in range(m)] for _ in range(n)]
    cnt = 0
    
    for _ in range(k):
        a,b = map(int,sys.stdin.readline().split())
        matrix[b][a] = 1
        
    for r in range(n):
        for c in range(m):
            if(matrix[r][c] == 1):
                bfs(r,c)    
                cnt += 1
    print(cnt)