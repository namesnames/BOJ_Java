L,C = map(int,input().split())
arr = list(input().split())
arr = sorted(arr)

moum = ['a','e','i','o','u']
    
s = []  
ans = []  
def dfs(start):
    global s
    global ans
    total = s.count('a') + s.count('e') + s.count('i') + s.count('o') + s.count('u') 
    if(len(s) == L and total>0 and len(s) - total>=2): # 자음도 2개 이상 있어야 한다는 것을 주의
        print(''.join(map(str,s)))
        #ans.append(s[:])
        return
    
    for i in range(start,C):
        s.append(arr[i])
        dfs(i+1)
        s.pop()
        
        
dfs(0)

# for a in sorted(ans):
#     print(*a,sep='')
        

