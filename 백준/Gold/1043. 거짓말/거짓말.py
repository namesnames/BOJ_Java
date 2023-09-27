import sys
input = sys.stdin.readline

N,M = map(int,input().strip().split())
trueman = list(map(int,input().strip().split()))[1:]
visited = [-1]


for t in trueman:
    visited.append(t)
# 총 두 바퀴 돌릴 거임
# 먼저 한 바퀴 돌려서 visited 채우자
all_li = []
for i in range(M):
    check = False
    
    all_li.append(list(map(int,input().strip().split()))[1:])
    for a in all_li[i]:
        if(a in trueman):
            check = True
            break
    if(check == True):
        for a in all_li[i]:
            visited.append(a)

for _ in range(M):
    for li in all_li:
        th_check = False
        for a in li:
            if(a in visited):
                th_check = True
                break
        if(th_check == True):
            for a in li:
                visited.append(a)         

visited_set = set(visited)

cnt = 0             
for li in all_li:

    for a in li:
        if(a in visited_set):
            cnt += 1
            break
print(M - cnt)        
            