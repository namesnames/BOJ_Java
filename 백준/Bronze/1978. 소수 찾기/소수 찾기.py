import sys
t = int(sys.stdin.readline())
alist = list(map(int,sys.stdin.readline().split()))

count = 0

for i in range(len(alist)):
    k = alist[i]
    check = True
    if(k == 1):
        pass
    elif(k == 2):
        count += 1
    else:
        for j in range(2,k):
            if(k % j == 0):
                check = False
        if(check == True):
            count += 1
            
print(count)