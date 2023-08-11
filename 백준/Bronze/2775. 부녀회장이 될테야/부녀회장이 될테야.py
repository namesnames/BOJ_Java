import sys
# t = int(sys.stdin.readline())

# def dp(a,b):
#     if(a == 0):
#         return b
#     elif(b == 1):
#         return 1
#     return dp(a,b-1) + dp(a-1,b)  # a층의 b호 =  a층의 b-1호 + a-1층의 b호 

# for _ in range(t):
#     a = int(sys.stdin.readline())
#     b = int(sys.stdin.readline())
#     print(dp(a,b))  
# <--------> 재귀로 풀면 백준에서 시간초과가 많이 난다네요..

t = int(sys.stdin.readline())

for _ in range(t):
    a = int(sys.stdin.readline())
    b = int(sys.stdin.readline())
    li = [i for i in range(1, b+1)] #이렇게 하면 li의 마지막인덱스가 b-1인 것을 주의하자..!
    
    for _ in range(a):
        for i in range(1, b):
            li[i] += li[i-1]
            
    print(li[b-1])  # 마지막 호실의 사람 수 출력

