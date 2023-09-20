import sys
sys.setrecursionlimit(10**7)
n = int(input())
matrix = [[0 for _ in range(n)] for _ in range(n)]
checkrix = [[0 for _ in range(n)] for _ in range(n)]
visited = [0 for _ in range(n)]

# 처음에 visted에 시작 정점 포함 ㄴㄴ
def dfs(r): #checkrix[r]를 일종의 visited로 사용할 예정
    for next in range(n):
        if(visited[next] == 0 and matrix[r][next] == 1):
            visited[next] = 1
            dfs(next)
            
            
for i in range(n):
    matrix[i] = list(map(int,input().split()))

for r in range(n):
    dfs(r)
    checkrix[r] = visited
    visited = [0 for _ in range(n)]
    
for r in checkrix:
    print(*r)
