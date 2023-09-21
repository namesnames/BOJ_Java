import sys
input = sys.stdin.readline

N,M = map(int,input().split())

treeList = list(map(int,input().split()))

start = 0
end = max(treeList)

while start <= end:
    Sum = 0
    mid = (start + end) // 2
    for i in treeList:
        if(i > mid):
            Sum += i - mid
        else:
            pass
    if(Sum < M):
        end = mid - 1
    else:
        start = mid + 1
print(end)        
