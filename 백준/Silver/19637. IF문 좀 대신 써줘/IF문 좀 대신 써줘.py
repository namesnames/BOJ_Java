import sys
input = sys.stdin.readline

N,M = map(int,input().split())
powerlist = []
namelist = []

for _ in range(N):
    a,b = input().split()
    namelist.append(a)
    powerlist.append(int(b))
    
    
for _ in range(M):
    a = int(input())
    end = N-1
    start = 0
    while start <= end:
            mid = (start + end) // 2
            if(a > powerlist[mid]):
                start = mid + 1
            else:
                end = mid - 1
    print(namelist[end+1]) # 왜 end+1이냐? 전투력이 99999이면 Weak가 아니라 그 다음인 Normal을 출력해야하니까            
            
            
    
        