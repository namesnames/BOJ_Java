from collections import deque
N,K = map(int,input().split())

visted = [0 for _ in range(100001)]

def bfs(x):
    dq = deque()
    dq.append(x)
    visted[x] = 0
    while dq:
        cur = dq.popleft()
        if(cur == K):        
            print(visted[cur])
            break

        for d in (cur-1,cur+1,2*cur):
            if(0<=d<100001 and visted[d] == 0):
                dq.append(d)
                visted[d] = visted[cur] + 1
                    
bfs(N)            