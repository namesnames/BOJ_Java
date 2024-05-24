N = int(input())


arr = []
for _ in range(N):
    arr.append(int(input()))

answer = 5
for a in arr:
    for i in range(0,5):
        temp = []
        for j in range(a-4,a+1):
            temp.append(j+i)
        ans = 5
        for t in temp:
            if(t in arr):
                ans -= 1    
        answer = min(answer,ans)

print(answer)