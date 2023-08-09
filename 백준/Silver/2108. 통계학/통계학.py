import sys
from collections import Counter

t = int(sys.stdin.readline())
alist = []
for _ in range(t):
    alist.append(int(sys.stdin.readline()))
    
# 평균

print(round(sum(alist)/len(alist)))

sortedList = sorted(alist)
index = len(alist) // 2
print(sortedList[index])

countList = Counter(sortedList).most_common()
if(len(countList) > 1 and countList[0][1] == countList[1][1]):
    print(countList[1][0])
else:
    print(countList[0][0])


    
maxnum = max(alist)
minnum = min(alist)

print(maxnum-minnum)
