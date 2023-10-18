N,M = map(int,input().split())

arr = list(map(int,input().split()))
arr = sorted(arr)

s = []
ans = []

def backtracking(k):
    if(len(s) == M):
        
        ans.append(s[:])
        return
    
    for i in range(k,N):
        s.append(arr[i])
        backtracking(i)
        s.pop()

backtracking(0)


newans = []
for a in ans:
    newans.append(tuple(a))

newans = sorted(list(set(newans)))

for w in newans:
    print(*w)