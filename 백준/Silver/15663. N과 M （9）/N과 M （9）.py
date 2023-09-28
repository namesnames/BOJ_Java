N,M = map(int,input().split())
arr = list(map(int,input().split()))
arr = sorted(arr)

s = []
ans = []
visited = [0 for _ in range(N)]
def dfs():
    if(len(s) == M):
        ans.append(s[:])
        return
    
    for i in range(0,N):
        if(visited[i] == 0):
            visited[i] = 1
            s.append(arr[i])
            dfs()
            s.pop()
            visited[i] = 0

dfs()

newans = []
for a in ans:
    newans.append(tuple(a))
ans_set = set(newans)
ans_set_list = list(ans_set)

for a in sorted(ans_set_list):
    print(*a)
