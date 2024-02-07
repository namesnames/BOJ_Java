from collections import deque

# 첫 행,열 & 마지막 행,열 

N,M,R = map(int,input().split())
matrix = []
answer = [[0 for _ in range(M)] for _ in range(N)]
for r in range(N):
    matrix.append(list(map(int,input().split())))

rstart = 0
rend = N
cstart = 0
cend = M

dq = deque()

l = min(M,N) # 주의 # 껍데기 갯수는 N과 M중 작은 것을 기준으로 정해짐

for i in range(l//2):
    for c in range(i, M-i):
        dq.append(matrix[i][c]) # 맨위 ->

    for r in range(i , N-i):
        if(r != i): # 맨 오른쪽 모서리 중복처리
            dq.append(matrix[r][M-i-1]) # 맨 오른쪽

    for c in range(M- i-1, i,-1):
        if(c != M-i-1):
            dq.append(matrix[N- i-1][c]) # 맨 아래  <-

    for r in range(N- i-1, i ,-1):
        if(r != N-i-1 or r != i-1):
            dq.append(matrix[r][i]) #맨 왼쪽 

    dq.rotate(-R)       

    for c in range(cstart+i, cend-i):
        answer[rstart + i][c] = dq.popleft() # 맨위 ->

    for r in range(rstart+i , rend-i):
        if(r != rstart+i): # 맨 오른쪽 모서리 중복처리
            answer[r][cend - i-1] = dq.popleft() # 맨 오른쪽

    for c in range(cend - i-1, cstart+i,-1):
        if(c != cend -i-1):
            answer[rend - i-1][c] = dq.popleft() # 맨 아래  <-

    for r in range(rend - i-1, rstart+i ,-1):
        if(r != rend -i-1 or r != rstart-1):
            answer[r][cstart +i] = dq.popleft() #맨 왼쪽 

for r in answer:
    print(*r)