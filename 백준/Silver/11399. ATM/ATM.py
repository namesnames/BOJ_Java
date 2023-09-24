import sys
input = sys.stdin.readline

N = int(input().strip())

ans = list(map(int,input().strip().split()))

ans = sorted(ans)


for j in range(1,N):
    ans[j] = ans[j-1] + ans[j]

print(sum(ans))