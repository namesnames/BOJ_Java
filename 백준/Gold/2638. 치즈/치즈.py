from collections import deque
import sys
input = sys.stdin.readline

N,M = map(int,input().split())

dr = [0,-1,0,1]
dc = [1,0,-1,0]

def possible(r,c):
    
    pcnt = 0
    for d in range(4):
        nr = r + dr[d]
        nc = c + dc[d]
        if(matrix[nr][nc] == 0 and visited[nr][nc] == 1):
            pcnt += 1
    if(pcnt >= 2):
        return True
    else:
        return False


def bfs():
    border = deque()
    cnt = 0
    
    while(dq):
        r,c = dq.popleft()
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if(0<=nr<N and 0<=nc<M and visited[nr][nc] == 0): # 안가본 곳이면 가봐
                if(matrix[nr][nc] == 0):
                    dq.append([nr,nc])
                    visited[nr][nc] = 1
                if(matrix[nr][nc] == 1): # 근데 와본 이곳이 치즈자리야?
                    border.append([nr,nc]) # border에 입갤
                    visited[nr][nc] = 1
                    cnt += 1
    possi = []
    for br,bc in border:
        if(possible(br,bc)):
            possi.append([br,bc])

    for pr, pc in possi:
        matrix[pr][pc] = 0
            
    return cnt



                

matrix = []
for _ in range(N):
    matrix.append(list(map(int,input().rstrip().split())))



hour = 0
while True:
    dq = deque()
    dq.append([0,0])
    visited = [[0 for _ in range(M)] for _ in range(N)]
    cnt = bfs()
    
    if(cnt == 0):
        break
    hour += 1

print(hour)

