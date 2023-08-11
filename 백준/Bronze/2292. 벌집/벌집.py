# 해당 숫자가 몇 번째 껍질에 있는지 # 한 껍질 밖으로 갈수록 6개가 추가됨
import sys

num = int(sys.stdin.readline())
i = 1
k = 1
low = 2
while True:
    i = 6 * k
    up = low + i
    if(num == 1): # 1일때 무한루프가 걸려서 시간초과가 나옴
        print(1)
        break
    elif(low <= num and num < up):
        print(i // 6 + 1)
        break
    low = up 
    k += 1
