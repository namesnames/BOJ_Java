N,M = map(int,input().split())

arr = list(map(int,input().split()))
arr = sorted(arr)

s = []

def backtracking():
    if(len(s) == M):
        print(' '.join(map(str,s)))
        return
    
    for i in arr:
        if i not in s:
            s.append(i)
            backtracking()
            s.pop()

backtracking()
