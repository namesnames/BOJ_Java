# 분할정복 문제
# 쿼드트리

import sys
input = sys.stdin.readline

n = int(input())

matrix = []

for i in range(n):
    matrix.append(list(map(int,input().strip().split())))
    
arr = [0,0]

def sol(r,c,N):
    color = matrix[r][c]
    for a in range(r,r+N):
        for b in range(c,c+N):
            if(color != matrix[a][b]):
                sol(r,c,N//2)
                sol(r,c+N//2,N//2)
                sol(r+N//2,c,N//2)
                sol(r+N//2,c+N//2,N//2)
                return #여기에 return이 없으면? # 최초에 이제 색이 안맞은거를 발견하면 4등분 될 텐데 
                       # 그 때 4등분을 호출한 sol함수 본체는 사라져야하는게 맞지
                       # 안사라지면 아래있는 if else문 실행되서 쓸데 없이 arr[0]이나 arr[1]값만 올라간다
    if(color == 0):
        arr[0] += 1
    else:
        arr[1] += 1
        
sol(0,0,n)
print(arr[0])
print(arr[1])
        
    
