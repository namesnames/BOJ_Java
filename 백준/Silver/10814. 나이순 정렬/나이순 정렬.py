n = int(input())
li = []
for _ in range(n):
    a,b = map(str,input().split())
    a = int(a)
    li.append((a,b))
    
sorted_li = sorted(li,key = lambda x:x[0])
for i,j in sorted_li:
    print(i,j)