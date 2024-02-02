from collections import deque
dq = deque()
N = int(input())
for i in range(N,0,-1):
    dq.append(i)

while(len(dq) != 1):
    dq.pop() #버리고
    dq.appendleft(dq.pop()) # 옮기고
    

print(*dq)