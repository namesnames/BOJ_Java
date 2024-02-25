N,d,k,c = map(int,input().split())
belt = []
for _ in range(N):
    belt.append(int(input()))


check = [0] * (d+1)

# 쿠폰 먼저 먹고 시작
check[c] += 1
eat = 1
max_eat = eat

for i in range(k):

    sushi = belt[i % N]

    if check[sushi]== 0:
        eat += 1
    check[sushi] += 1

for i in range(N):
    start = belt[i % N] # 뺄 녀석
    end = belt[(i+k) % N] # 새로 추가할 녀석
    
    check[start] -= 1 # 빼 주기

    if check[start] == 0:
        eat -= 1 # 먹은 거 빼주기

    if check[end] == 0:
        eat += 1

    check[end] += 1
    max_eat = max(max_eat,eat)

print(max_eat)