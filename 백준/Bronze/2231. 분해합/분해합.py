num = int(input())

check = True
for i in range(num):
    sumNum = 0
    stringNum = str(i)
    for a in stringNum:
        sumNum += int(a)
    if(num == sumNum + i):
        print(i)
        check = False
        break
if(check == True):        
    print(0)
            