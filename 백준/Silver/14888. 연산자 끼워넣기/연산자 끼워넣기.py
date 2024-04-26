
N = int(input())
num = list(map(int,input().split()))
plus,minus,multiple,divide = map(int,input().split())

maximum = -1e9
minimum = 1e9

def backtracking(depth, total, plus, minus, multiple, divide):
    global maximum,minimum # 전역변수를 함수 안에서 수정하려면 global
    if(depth == N):
        maximum = max(total,maximum)
        minimum = min(total,minimum)
        return
    
    if(plus > 0):
        backtracking(depth+1, total+num[depth], plus-1, minus, multiple, divide)
    if(minus > 0):
        backtracking(depth+1, total-num[depth], plus, minus-1, multiple, divide)
    if(multiple > 0):
        backtracking(depth+1, total*num[depth], plus, minus, multiple-1, divide)
    if(divide > 0):
        backtracking(depth+1, int(total / num[depth]), plus, minus, multiple, divide-1) # int로 감싼건 소숫점 버리려고

backtracking(1,num[0],plus,minus,multiple,divide)
print(maximum)
print(minimum)
