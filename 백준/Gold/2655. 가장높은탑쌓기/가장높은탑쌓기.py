
# dp[i]는 i번째 상자가 맨 위에 있을 때, 그 탑의 최대 높이를 의미함

N = int(input())
arr = []
for i in range(N):
    A,H,W = map(int,input().split())
    arr.append([A,H,W,i])

arr = sorted(arr,key = lambda x: x[0], reverse=True)
dp = [0] * N
dp[0] = arr[0][1]
tempHigh = dp[0]
ans = []
for i in range(1,N):
    tempHigh = dp[i]
    for j in range(i,-1,-1):
        if(arr[i][2] < arr[j][2] and tempHigh < dp[j]): # 나(i) 이전 녀석 중에 나보다 무게도 많이 나가고 지금 까지 가장 높은 녀석
            tempHigh = dp[j]         
    dp[i] = tempHigh + arr[i][1]

maxHigh = max(dp)
index = N-1
history = []

while (index != -1):
    if(dp[index] == maxHigh):
        history.append(arr[index][3] + 1)
        maxHigh -= arr[index][1]
    index -= 1
print(len(history))
for h in history:
    print(h)