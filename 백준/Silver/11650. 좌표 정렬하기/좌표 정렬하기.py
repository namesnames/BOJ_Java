T = int(input())
li = []
for _ in range(T):
    x,y = map(int,input().split())
    li.append((x,y))

sorted_li = sorted(li)
for x,y in sorted_li:
    print(x, y)