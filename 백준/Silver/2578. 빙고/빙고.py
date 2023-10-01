matrix = []

for _ in range(5):
    matrix.append(list(map(int,input().split())))

visited = [[0 for _ in range(5)] for _ in range(5)]

def check():
    b = 0
    for r in range(5):
        if(0 not in visited[r]):
            b += 1

    for c in range(5):
        total = 0
        for r in range(5):
            total += visited[r][c]
        if(total == 5):
            b += 1

    #대각선은 2번밖에 안되니까 걍 체크
    
    if(visited[0][0] + visited[1][1] + visited[2][2] + visited[3][3] + visited[4][4] == 5):
        b += 1
    if(visited[0][4] + visited[1][3] + visited[2][2] + visited[3][1] + visited[4][0] == 5):
        b += 1
    
    if(b >= 3):
        return True
    
inMatrix = []    

cnt = 0

for _ in range(5):
    inMatrix.append(list(map(int,input().split())))

for x in range(5):
    for y in range(5):
        bingo = False
        a = inMatrix[x][y]
        cnt += 1
        for r in range(5):
            for c in range(5):
                if(matrix[r][c] == a):
                    visited[r][c] = 1
                    bingo = check()
                    if(bingo == True):
                        print(cnt)
                        exit()
        
