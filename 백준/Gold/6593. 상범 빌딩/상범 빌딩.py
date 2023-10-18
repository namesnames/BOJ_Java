import sys
from collections import deque

input = sys.stdin.readline

dr = [0,1,0,-1,0,0]
dc = [1,0,-1,0,0,0]
dz = [0,0,0,0,1,-1]

def bfs():
    global dq
    global visited
    global cnt
    global isEscape
    while dq:
        z,r,c = dq.popleft()

        if(matrix[z][r][c] == 'E'):
            print(f'Escaped in {visited[z][r][c]} minute(s).')
            isEscape = True
            return
        for i in range(6):
            nr = r + dr[i]
            nc = c + dc[i]
            nz = z + dz[i]
            if(0<=nr<R and 0<=nc<C and 0<=nz<L and (matrix[nz][nr][nc] == '.' or matrix[nz][nr][nc] == 'E') and visited[nz][nr][nc] == 0):
                dq.append([nz,nr,nc])
            
                visited[nz][nr][nc] = visited[z][r][c] + 1
    

    

while True:

    L,R,C = map(int,input().split())
    if(L == 0 and R ==0 and C == 0):
        break

    tmp = []    
    matrix = []
    dq = deque()


    for z in range(L):
        floor = []
        for r in range(R):
            floor.append(list(input().strip()))
        matrix.append(floor)
        input()

    for z in range(L):
        for r in range(R):
            for c in range(C):
                if(matrix[z][r][c] == 'S'):
                    dq.append([z,r,c])    

    visited = [[[0 for _ in range(C)] for _ in range(R)] for _ in range(L)]
    cnt = -1
    isEscape = False
    bfs()   
    
    if(isEscape == False):
        print('Trapped!')


