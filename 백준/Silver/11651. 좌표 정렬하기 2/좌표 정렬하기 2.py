import sys
T = int(input())
li = []
for _ in range(T):
    a,b = map(int,sys.stdin.readline().split())
    li.append((a,b))  
li.sort(key = lambda x : (x[1],x[0]))
for i in li:
    print(i[0],i[1])