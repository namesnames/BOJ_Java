T = int(input())

for _ in range(T):
    N = int(input())    
    arr = [0 for _ in range(N+1)]

    for _ in range(N):
        a,b = map(int,input().split())
        arr[a] = b
        
    maxnum = arr[1]
    ans = 1
    for i in range(2,N+1):
        if(arr[i] < maxnum):
            maxnum = arr[i]
            ans += 1
            
        
    print(ans)
    