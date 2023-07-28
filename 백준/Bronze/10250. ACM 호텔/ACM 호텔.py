T = int(input())
for i in range(T):
    a,b,c = map(int,input().split())
    floor = 0
    room = 0
    if((a == c) or (c%a==0)):     #나머지가 0이 되는 순간을 조심해야함.. 그리고 1 5 4 같은 반례도 주의
        floor = a
        room = c // a
    else:
        floor = c % a
        room = (c // a) + 1
    print(floor*100 + room)

