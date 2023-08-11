#파이썬 내장함수 말고 유클리드 호제법 이용
# 유클리드 호제법 -> 최대 공약수 구함
# 두 값의 곲을 최대 공약수로 나눠주면 그것이 -> 최소 공배수
# 유클리드 호제법 
# 20 % 12 를 해준다. 나머지는 8이다.
# 12 % 8 을 해준다. 나머지는 4이다.
# 8 % 4 를 해준다. 나머지는 0이다.
# 나머지가 0이니 4가 20과 12의 최대 공약수이다.
# 즉 (나머지가 0됐을 때 나눠준 놈이 최대공약수)

def gcd(a,b):
    a,b = max(a,b), min(a,b)
    while b != 0:  # b가 0되면 stop
        a, b = b, a%b
    return a

def lcm(a,b):
    return a*b // gcd(a,b)

a,b = map(int,input().split())
print(gcd(a,b))
print(lcm(a,b))

    