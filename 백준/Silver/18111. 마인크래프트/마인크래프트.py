import sys
N,M,B = map(int,sys.stdin.readline().split())
mat = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
low = min([min(x) for x in mat])
high = max([max(x) for x in mat])

answer_time = float('inf')
answer_level = 0
#목표레벨이 i
for i in range(high,low-1,-1): # 동일한 시간일 때 더 높은 층을 답으로내야 하는데 if else로 끝내려고 256부터 탐색
    inven = B
    time = 0
    a = 0
    b = 0
    for x in range(N):
        for y in range(M):
            if(i > mat[x][y]): # 블럭 쌓기
                a += i - mat[x][y] # 인벤에서 뺄 블럭 수
               
            else: # 블럭 제거
                b += mat[x][y] - i # 제거한 블럭 수 = 인벤에 추가할 블럭 수
    inven += b - a            
    if(inven < 0):
        continue
    time = a + 2*b

    if(time < answer_time): # 더 짧은 시간이 나오면 답 change # 이 때 시간이 같아도 change안됨 # 따라서 더 높은 층일 때가 답이게 됨
        answer_time = time
        answer_level = i

print(answer_time,answer_level)