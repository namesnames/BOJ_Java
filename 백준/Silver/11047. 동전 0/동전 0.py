N,K = map(int,input().split())
inli = []

for _ in range(N):
    inli.append(int(input()))

cnt = 0

for i in reversed(inli):
    mok = K // i
    if(mok == 0):
        pass
    else:
        cnt += mok
        K -= (mok * i)

print(cnt)            
