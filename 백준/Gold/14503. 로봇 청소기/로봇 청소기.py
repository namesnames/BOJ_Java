N,M = map(int,input().split())

r,c,d = map(int,input().split())

# 북 동 남 서
dr = [-1,0,1,0]
dc = [0,1,0,-1]
matrix = []
# 그래프 그리기
for _ in range(N):
    matrix.append(list(map(int,input().split())))

flag = True        
gr = r
gc = c
cnt = 0
exist = 0

while True:
    flag = False
    
    if(matrix[gr][gc] == 1):
        break
    elif(matrix[gr][gc] == 0):        
        matrix[gr][gc] = 2 # 현재 위치 청소
        cnt += 1
    
    exist = 0
    # 이제 주변을 봐야하는데 일단 90도로 돌아
    for k in range(4):
        nr = gr + dr[k]
        nc = gc + dc[k]
        if(0<=nr<N and 0<=nc<M and matrix[nr][nc] == 0):
            exist += 1
        
    if(exist > 0):
        while True:
            d = (d+3) % 4 # 방향돌리기
            ngr = gr + dr[d] # 현재 위치에서 방향돌려서
            ngc = gc + dc[d] # 앞으로 전진
            if(matrix[ngr][ngc] == 0): # 가보려 했더니 갈 수 있으면 여기서 멈추고 진행
                gr = ngr
                gc = ngc
                flag = True
                break
            
    # for문에 들어가지 못했다면 후진할 차례
    if(flag == False):
        s = (d+2) % 4
        gr = gr + dr[s]
        gc = gc + dc[s]

print(cnt)    
