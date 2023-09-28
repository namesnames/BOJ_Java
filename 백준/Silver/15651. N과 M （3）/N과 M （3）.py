N,M = map(int,input().split())
s = []
ans = []

def backtracking():
    if(len(s) == M):
        ans.append(s[:])
        return
    for i in range(1,N+1):
    
        s.append(i)
        backtracking()
        s.pop()

backtracking()
for a in ans:
    print(*a)