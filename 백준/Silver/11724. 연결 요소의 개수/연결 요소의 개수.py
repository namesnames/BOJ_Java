import sys
sys.setrecursionlimit(10**7)

N,M = map(int,input().split())

def dfs(i):
    visted[i] = 1
    for next in range(1,N+1):
        if(visted[next] == 0 and matrix[i][next] == 1):
            dfs(next)

matrix = [[0 for _ in range(N+1)] for _ in range(N+1)]
visted = [0 for _ in range(N+1)]

for _ in range(M):
    u,v = map(int,sys.stdin.readline().split())
    matrix[u][v] = matrix[v][u]  = 1

cnt = 0
for i in range(1,N+1):
    if(visted[i] == 0):
        dfs(i)
        cnt += 1
print(cnt)        
        