from collections import deque

N,K = map(int,input().split())
inputList = list(map(int,input().split()))

belt = deque()
robot = deque()

for a in inputList:
    belt.append(a)
    robot.append(0) # 0이면 빈 칸

level = 1

while True:

    #회전
    belt.rotate(1)
    robot.rotate(1)
    robot[N-1] = 0 # 로봇내리기

    #이동
    for i in range(N-2,-1,-1): # N-2부터 1까지 -1빼면서
        if(robot[i]==1 and robot[i+1]==0 and belt[i+1]>0): #현재 로봇이 있고 다음칸에 로봇없고 다음벨트 내구도도 0이상이고 
            robot[i+1],robot[i] = 1,0  # 이 부분에서 robot[i+1],robot[i] = robot[i],robot[i-1]로 하면 안됨
            if(robot[i+1] == 1):
                belt[i+1] -= 1

    robot[N-1] = 0 # 로봇 내리기
    
    
    #올리기
    if(belt[0] > 0): # 내구도가 0보다 크면
        robot[0] = 1 #로봇 올리기
        belt[0] -= 1 # 내구도 1 감소
        

    if(belt.count(0) >= K):
        break
    
    level += 1

print(level)    
