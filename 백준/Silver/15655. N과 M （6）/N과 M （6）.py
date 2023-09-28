N,M = map(int,input().split())

arr = list(map(int,input().split()))
arr = sorted(arr)
s = []
ans = []

def backtracking(start):
    if(len(s) == M):
        ans.append(s[:])
        return
    for i in range(start,N):
        if(arr[i] not in s):
            s.append(arr[i])
            backtracking(i+1)
            s.pop()
            
backtracking(0)            

for a in ans:
    print(*a)