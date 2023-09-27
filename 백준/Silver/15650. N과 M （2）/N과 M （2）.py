import itertools
a,b = map(int,input().split())
arr = [i for i in range(1,a+1)]
li = list(itertools.combinations(arr,b))
for a in sorted(li):
    print(*a)
    