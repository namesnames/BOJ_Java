import sys
input = sys.stdin.readline().strip()

li = input

Max = ""
Min = ""
m = 0
for a in li:
    if(a == "M"):
        m += 1  # K가 나오기 전에 M이 몇 개 나왔는지 카운트
    else:
        if m:
            Max += str(5 * (10 ** m))  # K가 나오면 앞의 M까지 포함하기
            Min += str((10 ** m) + 5) # K가 나오면 앞의 M이랑 K 따로
        else:
            Max += '5'
            Min += '5'
        m = 0

if m: # K가 안나오고 M만으로 끝나면  ex) MMM -> 제일 크게하면 111 제일 작게하면 100
    Max += str("1" * m)
    Min += str(10 ** (m-1))
        
print(Max)
print(Min)
        