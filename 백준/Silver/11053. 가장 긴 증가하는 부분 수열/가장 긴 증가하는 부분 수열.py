N = int(input())
arr = list(map(int,input().split()))

# "현재의 나"를 포함해서 가장 긴 부분수열을 기록

# 나보다 전의 녀석들을 다 확인해봐야함
# 나보다 작으면서 가지고 있는 값(그 녀석까지의 부분수열)이 큰 녀석을 pick

dp = [1] * N # 우선 다 1로 초기화 -> 언제든 본인이 부분수열의 시작이 될 수 있기 때문
for i in range(1,N):
    tempDpMax = 1 #맨 loop마다 temp를 1로 초기화 -> 그래야 최대값이 올 때 tempDpMax를 그 최대값으로 바꿀 수 있기 때문
    for j in range(i-1,-1,-1):
        if(arr[i] > arr[j] and tempDpMax <= dp[j]):
            tempDpMax = dp[j]
            dp[i] = tempDpMax + 1
            
print(max(dp))
            
