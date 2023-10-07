# 톱니바퀴들은 동시다발적으로 이루어지기 때문에 DP를 사용하는게 좋을듯
# https://inspirit941.tistory.com/147

from collections import deque

gear = []

def check_left(start,d): # 왼쪽 톱니로 넘어가서 오른쪽에 있는 톱니랑 비교하는 함수
    if(start < 0):
        return
    if(gear[start +1][6] == gear[start][2]):
        return
        
    if(gear[start +1][6] != gear[start][2]):
        check_left(start-1,-d)
        gear[start].rotate(d) # 해당 톱니 돌리기 전에 재귀를 통해 왼쪽으로 한 번 더 가서 진행
        
def check_right(start,d): # 오른쪽으로 넘어가서 왼쪽에 있는 톱니랑 비교하는 함수
    if(start > 3):
        return
    if(gear[start -1][2] == gear[start][6]):
        return
    if(gear[start -1][2] != gear[start][6]):
        check_right(start+1,-d)
        gear[start].rotate(d) # 해당 톱니 돌리기 전에 재귀를 통해 오른쪽으로 한 번 더 가서 진행
            
        

for _ in range(4):
    gear.append(deque(list(map(int,input()))))
    
    
n = int(input())
for _ in range(n):
    start,d = map(int,input().split()) 
    start -= 1
    check_left(start -1,-d)
    check_right(start +1,-d)
    gear[start].rotate(d)
    
ans = 0

for i in range(4):
    if(gear[i][0] == 1):
        if(i == 0):
            ans += 1
        elif(i == 1):
            ans += 2
        elif(i == 2):
            ans += 4
        elif(i == 3):
            ans += 8
            
print(ans)