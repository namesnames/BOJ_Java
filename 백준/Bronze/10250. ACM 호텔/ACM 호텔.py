T = int(input())
for i in range(T):
    a,b,c = map(int,input().split())
    floor = 0
    room = 0
    if((a == c) or (c%a==0)):
        floor = a
        room = c // a
    else:
        floor = c % a
        room = (c // a) + 1
    print(floor*100 + room)

