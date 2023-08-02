n,m = map(int,input().split())
arr = []
for _ in range(n):
    arr.append(int(input()))

start = 1
end = max(arr)    

while (start <= end): # 시작점과 끝점이 교차하기 전까지는 계속 진행
    cnt = 0
    mid = (start + end) // 2   # mid값을 1증가시키거나 1감소시키면서 상황을 지켜볼거임 // mid + 1 이나 mid -1 을 하지 않은 이유는 아마 start와 end를 보고 while을 끝내야해서 그렇지 않나 생각
    for i in range(n):
        cnt += arr[i] // mid
    if(cnt >=m): # 오 이렇게 했는데 되네?  
        start = mid + 1 # 그럼 이제 mid뒤는 볼 필요가 없다. start를 mid보다 1크게해서 앞 부분을 살펴보자
    else:
        end = mid - 1

print(end)
