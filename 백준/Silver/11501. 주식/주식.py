T = int(input())

for _ in range(T):
    N = int(input())
    arr = list(map(int,input().split()))
    temp = [0] * N
    temp[N-1] = 1

    trigger = arr[N-1]
    for i in range(N-1,-1,-1):
        if(arr[i] > trigger):
            temp[i] = 1
            trigger = arr[i]

    maxnum = 0
    ans = 0
    cnt = 0
    for i in range(N-1,-1,-1):
        if(temp[i] == 1):
            maxnum = arr[i]
            cnt += 1
        ans += maxnum - arr[i]
    
    if(cnt == 0):
        print(0)
        continue
    print(ans)