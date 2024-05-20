
def check(arr):
    cnt = 0
    for i in range(len(arr)):
        if(arr[i][0] <= 0):
            cnt += 1
    return cnt
    
def dfs(depth):
    global ans
    if(depth == N):
        ans = max(ans,check(arr))
        return
    
    for i in range(N):
        if(i != depth):
            if(arr[i][0] > 0 and arr[depth][0] > 0):
                arr[i][0] -= arr[depth][1]
                arr[depth][0] -= arr[i][1]
                dfs(depth+1)
                arr[i][0] += arr[depth][1]
                arr[depth][0] += arr[i][1]
            else:
                dfs(depth+1)
                
N = int(input())
arr = []
for _ in range(N):
    arr.append(list(map(int,input().split())))
ans = 0
dfs(0)
print(ans)
                