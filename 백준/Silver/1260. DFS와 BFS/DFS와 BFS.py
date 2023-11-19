
from collections import deque
N,M,V = map(int,input().split())

def dfs(idx):
    global visted
    visted[idx] = 1
    print(idx,end= " ")
    for next in range(N+1):
        if(visted[next] == 0 and matrix[idx][next] == 1 ):
            dfs(next)
          
def bfs(V):
    global dq
    global visted
    dq.append(V)
    visted[V] = 1 
    
    while dq:
        cur = dq.popleft()
        print(cur,end = " ")
        for next in range(N+1):
            if(visted[next] == 0 and matrix[cur][next] == 1):
                dq.append(next)
                visted[next] = 1
                
matrix = [[0 for _ in range(N+1)] for _ in range(N+1)]                

for _ in range(M):
    a,b = map(int,input().split())
    matrix[a][b] = matrix[b][a] = 1
    
visted = [0 for _ in range(N+1)]

dfs(V)
print()
dq = deque()
visted = [0 for _ in range(N+1)]
bfs(V)    