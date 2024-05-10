# https://hqjang.tistory.com/104 (트리 dp)
# 정점들은 얼리어답터이거나 아니거나 두 가지의 상태만 존재한다
# 현재의 나 기준으로, 내가 얼리어답터이면 자식은 얼리어답터이어도 되고, 아니어도 되서 min 값을 골라 나한테 더해주면 되고
# 내가 얼리어답터가 아니라면 자식은 무조건 얼리어답터이어야함
# dp는 [[0,0],[0,0],...] 이런식으로 이루어질 것인데 각 원소의 0 인덱스는 내가 얼리어답터가 아닐 때, 내 자식들을 고려했을 때의 얼리어탑터 수
# 1 인덱스는 내가 얼리어답터일때, 내 자식들을 고려했을 때의 얼리어탑터 수를 의미함

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

N = int(input())

matrix = [[] for _ in range(N+1)]

for _ in range(N-1): # 문제에서 간선정보는 N-1개만 받으라고 돼있음
    a,b = map(int,input().rstrip().split())
    matrix[a].append(b)
    matrix[b].append(a)

dp = [[0,0] for _ in range(N+1)] # [0,0] # 0인덱스 -> 내가 얼리어답터일 때, 1인덱스 -> 내가 얼리어답터가 아닐 때
visited = [0 for _ in range(N+1)] # 정점 방문 여부 기록

def solve_dp(v):
    visited[v] = 1
    dp[v][0] = 0 # 얼리어답터 수 = 0
    dp[v][1] = 1 # 얼리어답터 수 = 1

    for next in matrix[v]:
        if(visited[next] == 0):
            solve_dp(next)  # 아래에서 수정하기 전에 dp먼저 진행해야 함
            dp[v][0] += dp[next][1]
            dp[v][1] += min(dp[next][0], dp[next][1])
            
solve_dp(1) # root 부터 시작해서 내려간다
print(min(dp[1][0], dp[1][1]))