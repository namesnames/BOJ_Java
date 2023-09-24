import sys
input = sys.stdin.readline

a,b = map(int,input().split())

D = dict()

for i in range(1,a+1):
    word = input().rstrip()
    D[i] = word
    D[word] = i


for j in range(b):
    k = input().rstrip()
    if(k.isdigit()):
        k = int(k)
        print(D[k])
    else:
        print(D.get(k))