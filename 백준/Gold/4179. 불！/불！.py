import sys
from collections import deque

input = sys.stdin.readline

r,c = map(int,input().split())

f_visited = [[0 for _ in range(c)] for _ in range(r)]
j_visited = [[0 for _ in range(c)] for _ in range(r)]
matrix = [[0 for _ in range(c)] for _ in range(r)]

jdq = deque()
fdq = deque()

dr = [0,-1,0,1]
dc = [-1,0,1,0]


for i in range(r):
    matrix[i] = list(input())


for a in range(r):
    for b in range(c):
        if(matrix[a][b] == 'J'):
            j_visited[a][b] = 1
            jdq.append([a,b])
        elif(matrix[a][b] == 'F'):
            f_visited[a][b] = 1
            fdq.append([a,b])
        elif(matrix[a][b] == '#'):
            j_visited[a][b] = -1
            f_visited[a][b] = -1



def fbfs():    
    while fdq:
        fr,fc = fdq.popleft()
        for i in range(4):
            nfr = fr + dr[i]
            nfc = fc + dc[i]
            if(0<=nfr<r and 0<=nfc<c and f_visited[nfr][nfc] == 0):
                f_visited[nfr][nfc] = f_visited[fr][fc] + 1
                fdq.append([nfr,nfc])

def jbfs():
    while jdq:
        jr,jc = jdq.popleft()
        if(jr == r-1 or jc == c-1 or jr == 0 or jc == 0):
            print(j_visited[jr][jc])
            return
        for i in range(4):
            njr = jr + dr[i]
            njc = jc + dc[i]
            if(0<=njr<r and 0<=njc<c and j_visited[njr][njc] == 0 and ((f_visited[njr][njc] == 0) or (f_visited[njr][njc] > j_visited[jr][jc] + 1))):
                j_visited[njr][njc] = j_visited[jr][jc] + 1
                jdq.append([njr,njc])    
            
    print('IMPOSSIBLE')        
fbfs()           
jbfs()
