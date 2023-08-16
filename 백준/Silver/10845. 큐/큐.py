import sys
T = int(sys.stdin.readline())
li = []
for _ in range(T):
    command = list(map(str,sys.stdin.readline().split()))
    
    if(command[0] == 'push'):
        li.append(command[1])
    elif(command[0] == 'pop'):
        if li:
            print(li[0])
            li.pop(0)
        else:
            print(-1)
    elif(command[0] == 'size'):
        print(len(li))
    elif(command[0] == 'empty'):
        if li:
            print(0)
        else:
            print(1)
    elif(command[0] == 'front'):
        if not li:
            print(-1)
        else:
            print(li[0])
    elif(command[0] == 'back'):
        if not li:
            print(-1)
        else:
            print(li[-1])
            