N = int(input())

Aarr = list(map(int,input().split()))
Barr = list(map(int,input().split()))

Aarr.sort()
Barr.sort(reverse = True)

ans = 0
for i in range(len(Aarr)):
    ans += Aarr[i] * Barr[i]

print(ans)