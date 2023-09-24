import sys
input = sys.stdin.readline

N = int(input())

li = set()
for _ in range(N):
    li.add(int(input()))
    
sumSet = set()  
for a in li:
    for b in li:
        sumSet.add(a + b)
ans = []
for k in li:
    for c in li:
        if((k - c) in sumSet):
            ans.append(k)
ans = sorted(ans)            
print(ans[-1])                