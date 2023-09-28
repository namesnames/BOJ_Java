N,M = map(int,input().split())
arr = list(map(int,input().split()))
arr = sorted(arr)
s = []
ans = []

def backtracking():
    if(len(s) == M):
        ans.append(s[:])
        return
    for i in range(0,N):
        
        s.append(arr[i])
        backtracking()
        s.pop()
backtracking()
for a in ans:
    print(*a)
