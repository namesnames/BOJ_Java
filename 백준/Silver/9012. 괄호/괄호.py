# '('면 넣고 ')'만나면 넣은 거 삭제

T = int(input())
for _ in range(T):
    test = []
    check = True
    li = input()
    for a in li:
        if(a == '('):
            test.append(a)
        elif(a == ')'):
            try:
                test.pop()
            except:
                check = False
                break
    if(not test and check == True):
        print("YES")
    else:
        print("NO")
           
        
        
        
            