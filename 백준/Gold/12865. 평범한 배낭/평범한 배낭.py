import sys
input = sys.stdin.readline

N, K = map(int,input().rstrip().split())
bag = [[0,0]]
for _ in range(N):
    W,V = map(int,input().rstrip().split())
    bag.append([W,V])

dp = [[0 for _ in range(K+1)] for _ in range(N+1)] # N+1 x K+1 배열 # 아무것도 안넣었을 때부터 계산

for r in range(1,N+1):
    w,v = bag[r] # r번째 물건까지 고려한다는 의미
    for c in range(1,K+1):
        if(w <= c): #왼쪽부터 오른쪽으로 스캔할 건데 배낭의 limit인 c보다 넣어볼 물건의 무게 w가 작거나 같을 경우 진행
            dp[r][c] = max(dp[r-1][c], v + dp[r-1][c-w])
        else: # 넣어볼 물건의 무게w가 가방보다 클 경우는 그냥 위에서 계산했던 값 그대로 물려받기
            dp[r][c] = dp[r-1][c]

print(dp[N][K])


