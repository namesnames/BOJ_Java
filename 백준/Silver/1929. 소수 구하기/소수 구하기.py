M,N = map(int, input().split())
number = N
a = list(range(0, N+1))
def find_prime(M,N):
    for i in range(2,N+1):
        if a[i] ==0:
            continue
        else:
            for k in range(2*i,N+1,i): # 자기 자신을 제외한 그 배수는 모두 지우기
               # print(k)
                a[k] =0
    for i in range(M,N+1): # 소수 출력
        if a[i] ==0 or i ==1:
            continue
        else:
            print(a[i])
find_prime(M,N)