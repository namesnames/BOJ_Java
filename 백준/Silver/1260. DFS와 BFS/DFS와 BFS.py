from collections import deque

N,M,V = map(int,input().split())

def dfs(idx):
    #global visted # visted를 가져와서 계속 써야하니 global
    visted[idx] = 1 
    print(idx,end = ' ')
    for next in range(N+1):
        if(visted[next] == 0 and matrix[idx][next] == 1):
            dfs(next) 

    
def bfs():
    while dq:
        cur = dq.popleft()
        print(cur,end = ' ')
        for next in range(N+1):
            if(visted[next] == 0 and matrix[cur][next] == 1):
                dq.append(next)
                visted[next] = 1
                    
    
# N+1 크기의 graph를 만들자
matrix = [[0 for _ in range(N+1)] for _ in range(N+1)]
visted = [0 for _ in range(N+1)]

for _ in range(M):
    a,b = map(int,input().split())
    matrix[a][b] = matrix[b][a] = 1
    
# dfs
dfs(V)
print()

visted = [0 for _ in range(N+1)]

# bfs
dq = deque()
dq.append(V)
visted[V] = 1
bfs()


