
T = int(input())

for _ in range(T):
    N,M = map(int,input().split())
    A = []
    B = []

    A = list(map(int,input().split()))
    B = list(map(int,input().split()))

    A.sort()
    B.sort()
    
    Apointer = 0
    Bpointer = 0

    ans = 0
    while(Apointer < N and Bpointer < M):
        if(A[Apointer] > B[Bpointer]):
            Bpointer += 1
        else:
            ans += Bpointer
            Apointer += 1

    for _ in range(len(A) - Apointer):
        ans += Bpointer

    print(ans)