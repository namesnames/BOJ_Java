import sys

a = int(sys.stdin.readline()) 
aset = set(map(int,sys.stdin.readline().split()))

b = int(sys.stdin.readline())
blist = list(map(int,sys.stdin.readline().split()))

for c in blist:
    if(c in aset):
        print('1')
    else:
        print('0')

