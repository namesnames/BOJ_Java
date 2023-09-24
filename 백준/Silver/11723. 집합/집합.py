import sys
input = sys.stdin.readline

S = set()
M = int(input())
for _ in range(M):
    tmp = input().split()
    if(len(tmp) == 1):
        order = tmp[0]
    else:
        order = tmp[0]
        num = int(tmp[1])
    
    if(order == 'add'):
        S.add(num)
    elif(order == 'remove'):
        S.discard(num)
    elif(order == 'check'):
        if(num in S):
            print(1)
        else:
            print(0)
    elif(order == 'toggle'):
        if(num in S):
            S.discard(num)
        else:
            S.add(num)
    elif(order == 'all'):
        S = {i for i in range(21)}
    elif(order == 'empty'):
        S = set()
        
        
        