import sys
from collections import deque
input = sys.stdin.readline
T = int(input().strip())

dr = [0,-1,0,1]
dc = [-1,0,1,0]

def fbfs():
    while fdq:
        fr,fc = fdq.popleft()
        for next in range(4):
            nfr = fr + dr[next]
            nfc = fc + dc[next]
            if(0<=nfr<r and 0<=nfc<c and fvisited[nfr][nfc] == 0 and matrix[nfr][nfc] != '#'):
                fvisited[nfr][nfc] = fvisited[fr][fc] + 1
                fdq.append([nfr,nfc])
def sbfs():
    check = False
    while sdq:
        sr,sc = sdq.popleft()
        if(sr == 0 or sr == r-1 or sc == 0 or sc == c-1):
            print(svisited[sr][sc])
            check = True
            break
        for next in range(4):
            snr = sr + dr[next]
            snc = sc + dc[next]
            if(0<=snr<r and 0<=snc<c and svisited[snr][snc] == 0 and matrix[snr][snc] != '#' and ((fvisited[snr][snc]==0) or (fvisited[snr][snc] > svisited[sr][sc] + 1))):
                svisited[snr][snc] = svisited[sr][sc] + 1
                sdq.append([snr,snc])
    if(check == False):
        print("IMPOSSIBLE")                

for _ in range(T):
    c,r = map(int,input().strip().split())
    matrix = [[0 for _ in range(c)] for _ in range(r)]
    fdq = deque()
    sdq = deque()
    fvisited = [[0 for _ in range(c)] for _ in range(r)]
    svisited = [[0 for _ in range(c)] for _ in range(r)]
    for i in range(r):
        matrix[i] = list(input().strip())
        
    for a in range(r):
        for b in range(c):
            if(matrix[a][b] == '#'):
                fvisited[a][b] = -1
                svisited[a][b] = -1
            if(matrix[a][b] == '@'):
                svisited[a][b] = 1
                sdq.append([a,b])
            if(matrix[a][b] == '*'):
                fvisited[a][b] = 1
                fdq.append([a,b])
    fbfs()
    sbfs()

