from itertools import combinations
import sys

N,M = map(int,sys.stdin.readline().split())
li = list(map(int,sys.stdin.readline().split()))
answer = {}
for i in combinations(li,3):
    if(sum(i) <= M):
        answer[sum(i)] = i
        
sortedAnswer = sorted(answer.items(),reverse=True)
print(sortedAnswer[0][0])