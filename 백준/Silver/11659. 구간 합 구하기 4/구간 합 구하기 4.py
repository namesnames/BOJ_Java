import sys
input = sys.stdin.readline

N,M = map(int,input().strip().split())
arr = list(map(int,input().strip().split()))
arrSum = []
arrSum.append(0)
arrSum.append(arr[0])
for i in range(2,N+1):
    arrSum.append(arr[i-1] + arrSum[i-1])


for _ in range(M):
    a,b = map(int,input().split())
    if(b == 1):
        print(arr[0])
    else:
        print(arrSum[b] - arrSum[a-1])
    