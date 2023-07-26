n = int(input())


for i in range(n):
    a,b = input().split()
    a = int(a)
    
    result = ""
    
    for j in b:
        result += j * a
    print(result)
        