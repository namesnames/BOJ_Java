n = int(input())

matrix = list(map(int,input().split()))
    
maxnum = max(matrix)
                  
total = 0                  
for k in matrix:
    total += k/maxnum*100
                  
print(total/n)                  