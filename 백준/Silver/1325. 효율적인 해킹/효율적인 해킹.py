from collections import deque

def bfs(i):
    dq = deque()
    dq.append(i)
    
    cnt = 1
    while(dq):
        n = dq.popleft()
        for m in matrix[n]:
            if(visited[m] == 0):
                visited[m] = 1
                dq.append(m)
                cnt += 1
    return cnt

N,M = map(int,input().split())

matrix = [[] for _ in range(N+1)]
for _ in range(M):
    a,b = map(int,input().split())
    matrix[b].append(a)

ans = []

for i in range(1,N+1):
    visited = [0 for _ in range(N+1)]
    if(visited[i] == 0):
        visited[i] = 1
        ans.append([i,bfs(i)])
    
ans.sort(key = lambda x:(-x[1],x[0]))

maxnum = ans[0][1]

for a in ans:
    if(a[1] != maxnum):
        break
    else:
        print(a[0],end = " ")
    

