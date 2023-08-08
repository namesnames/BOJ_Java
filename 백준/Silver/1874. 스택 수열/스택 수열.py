n = int(input())
s = []
answer = []
check = True
count = 1
for _ in range(n):
    num = int(input())
    while(count <= num):
        s.append(count)
        answer.append('+')
        count += 1
    
    if(s[-1] == num):
        s.pop()
        answer.append('-')
    else:
        check = False
        print("NO")
        break
        
if(check == True):
    for i in answer:
        print(i)