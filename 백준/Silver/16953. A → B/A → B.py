a,b = map(int,input().split())
cnt = 1
while True:
    bstr = str(b)
    if(bstr[-1] == '1'):
        
        bstr = bstr[:-1]
        b = int(bstr)
    elif(b%2 ==0):
        b = b // 2
    else:
        print(-1)
        break   
        
    cnt += 1
    
    if(b == 0 or len(bstr)==0 or a>b):
        print(-1)
        break
    elif(b == a):
        print(cnt)
        break
