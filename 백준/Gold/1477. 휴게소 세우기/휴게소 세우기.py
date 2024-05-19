N,M,L = map(int,input().split())

arr = list(map(int,input().split()))
arr.append(0)  # 시작점도 추가
arr.append(L)  # 끝점도 추가
arr.sort()
interval = []
for i in range(len(arr)-1):
    interval.append(arr[i+1] - arr[i])

start = 1 # 안해주면 zerodivisionerror -> mid = (0+L)//2 같은 경우 -> mid = 0
end = max(interval)
mid = 0
while(start <= end):
    cnt = 0
    mid = (start + end) // 2
    for inter in interval:
        cnt += (inter - 1) // mid

    if(cnt <= M):
        end = mid-1
    else:
        start = mid+1

print(start)
