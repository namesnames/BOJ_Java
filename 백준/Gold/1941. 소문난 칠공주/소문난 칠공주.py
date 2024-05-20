from collections import deque

dr = [0,-1,0,1]
dc = [1,0,-1,0]

def bfs(S):
    bmatrix = [[0 for _ in range(5)] for _ in range(5)]
    for s in S:
        x = s // 5
        y = s % 5
        bmatrix[x][y] = 1

    visited = [[0 for _ in range(5)] for _ in range(5)]
    dq = deque()
    dq.append([S[0]//5, S[0]%5])
    
    
    checkCnt = 1 #넣을 때를 체크
    while(dq):   
        r,c = dq.popleft()
        visited[r][c] = 1 
     
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if(0<=nr<5 and 0<=nc<5 and bmatrix[nr][nc] == 1 and visited[nr][nc] == 0):
                dq.append([nr,nc])
                visited[nr][nc] = 1
                checkCnt += 1 # 넣을 때를 체크

    if(checkCnt == 7):
        return True
    else:
        return False


def dfs(start, depth, cnt):
    global ans
    
    if(cnt >= 4):
        return
    
    if(depth == 7):
        if(bfs(s) == True):
            ans += 1
        return

    for i in range(start,25):
        if(i not in s):
            s.append(i)
            dfs(i, depth+1, cnt + (matrix[i//5][i%5] == "Y"))
            s.pop()


matrix = []
for _ in range(5):
    matrix.append(list(input()))

s = []
ans = 0
dfs(0,0,0)
print(ans)

