# 플로이드 
# https://blog.encrypted.gg/1035 (바킹독)

import sys
input = sys.stdin.readline

N = int(input().rstrip())
M = int(input().rstrip())
INF = int(1e9)

matrix = [[INF]* N for _ in range(N)]
for r in range(N):
    matrix[r][r] = 0

for _ in range(M):
    a,b,c = map(int,input().rstrip().split())
    matrix[a-1][b-1] = min(matrix[a-1][b-1], c)  # 그냥 matrix[a-1][b-1] = c 로 하면 안되는게 # a,b,c가 중복돼서 들어올 수도 있어서임


for lv in range(N):
    for r in range(N):
        for c in range(N):
            matrix[r][c] = min(matrix[r][c], matrix[r][lv] + matrix[lv][c])

for r in range(N):
    for c in range(N):
        if(matrix[r][c] == INF):
            print(0,end=" ")
        else: 
            print(matrix[r][c],end=" ")
    print()