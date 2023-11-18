N,M = map(int,input().split())

s = []
ans = []

def backtracking(start):
    if(len(s) == M):
        ans.append(s[:])
        return
    
    for i in range(start,N+1):
        if(i not in s):
            s.append(i)
            backtracking(i+1)
            s.pop()

backtracking(1)
for a in ans:
    print(*a)