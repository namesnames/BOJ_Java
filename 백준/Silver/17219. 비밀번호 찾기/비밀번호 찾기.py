N,M = map(int,input().split())

D = dict()
for _ in range(N):
    a,b = input().split()
    D[a] = b
   
for _ in range(M):
    word = input()
    print(D[word])