import sys
t = int(sys.stdin.readline())
li = []
for _ in range(t):
    li.append(int(sys.stdin.readline()))

for a in sorted(li):
    print(a)