T = int(input())
li = []
for _ in range(T):
    a,b = map(int,input().split())
    li.append((a,b))
    
for a,b in li:
    cnt = 1
    for x,y in li:
        if(x>a and y>b):
            cnt += 1
    print(cnt)    
