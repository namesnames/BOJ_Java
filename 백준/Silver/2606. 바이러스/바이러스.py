from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    global cnt
    while dq:
        idx = dq.popleft()
        cnt += 1
        for next in range(1,N+1):
            if(visited[next] == 0 and matrix[idx][next] == 1):
                dq.append(next)
                visited[next] = 1
            
cnt = 0        
dq = deque()
N = int(input())
T = int(input())
visited = [0]* (N+1)
matrix = [[0 for _ in range(N+1)] for _ in range(N+1)]
for _ in range(T):
    a,b = map(int,input().strip().split())
    matrix[a][b] = matrix[b][a] = 1

dq.append(1)
visited[1] = 1
bfs()
print(cnt - 1)
    
