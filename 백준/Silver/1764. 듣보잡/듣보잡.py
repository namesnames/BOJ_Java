import sys
input = sys.stdin.readline

N,M = map(int,input().strip().split())

hearSet = set()
seeSet = set()

for _ in range(N):
    hearSet.add(input().strip())
for _ in range(M):
    seeSet.add(input().strip())
ans = []
ans = list(hearSet & seeSet)
print(len(ans))
for a in sorted(ans):
    print(a)
