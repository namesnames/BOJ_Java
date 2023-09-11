N,r,c = map(int,input().split())

visit = 0

while (N != 0):
    N -= 1
    size = 2 ** N
    
    if (r < size and c < size):
        visit += 0
        
    elif (r < size and size <= c):
        visit += size * size
        c -= size
        
    elif (size <= r and c < size):
        visit += 2 * size * size
        r -= size
        
    elif (size <= r and size <= c):
        visit += 3 * size * size
        c -= size
        r -= size
        
print(visit)        