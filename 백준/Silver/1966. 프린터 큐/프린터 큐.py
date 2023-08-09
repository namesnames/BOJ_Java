import sys
from collections import deque
t = int(sys.stdin.readline())

for _ in range(t):
    a,b = map(int,sys.stdin.readline().split())
    dq = deque(list(map(int,sys.stdin.readline().split())))
    
    
    count = 0
    while dq:
        maxnum = max(dq)
        front = dq.popleft()
        b -= 1
        if(front == maxnum):
            count += 1
            if(b < 0):
                print(count)
                break
        else:
            dq.append(front)
            if(b < 0):
                b = len(dq) - 1



           