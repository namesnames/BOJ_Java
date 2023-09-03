from itertools import combinations

while True:
    s = list(map(int,input().split()))
    if(s[0] == 0):
        break
    s.pop(0)
    for data in combinations(s,6):
        print(*data)  # *data가 아니라 data면 (1,2,3,4,5,6) 이런식으로 나옴
    print()