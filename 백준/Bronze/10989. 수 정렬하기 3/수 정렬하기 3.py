# 참고 https://yoonsang-it.tistory.com/49
# 시간은 넉넉하니까 for문은 괜찮고 메모리 문제 -> 입력받을 때마다 append하면 메모리재할당 = 메모리 ㄷㄷ
# 미리 배열을 10000개 할당 해놓는 방식으로 메모리 줄이기
import sys
T = int(sys.stdin.readline())
li = [0]*10001
for _ in range(T):
    li[int(sys.stdin.readline())] += 1
    
for i in range(10001):
    if(li[i] > 0):
        for _ in range(li[i]):
            print(i)