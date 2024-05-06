
# 2차원 배열에 간선정보 저장 (연결리스트 방식으로)
# dfs(1)부터 시작
# dfs(1)은 1에 연결된 정점들인 4와6의 부모를 1로 설정 (parent배열에 저장)
# dfs(4)와 dfs(6)도 똑같이 실행
# dfs(4)는 4에 연결된 정점들의 부모를 4로 설정
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
matrix = [[] for _ in range(N+1)]
for _ in range(N-1):
    a,b = map(int,input().rstrip().split())
    matrix[a].append(b)
    matrix[b].append(a)
    
parent = [0] * (N+1)
def dfs(v):
    for i in matrix[v]:
        if(parent[i] == 0):
            parent[i] = v
            dfs(i)
    return

dfs(1)
for i in range(2,N+1):
    print(parent[i])