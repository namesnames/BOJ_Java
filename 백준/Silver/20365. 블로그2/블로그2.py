n = int(input())
strList = input()
cnt1 = 0

if(strList[0] == 'R'):
    cnt1 += 1
for i in range(1,len(strList)):
    if(strList[i] == 'R' and strList[i-1] == 'B'):
        cnt1 += 1
        
cnt2 = 0 
if(strList[0] == 'B'):
    cnt2 += 1
for i in range(1,len(strList)):
    if(strList[i] == 'B' and strList[i-1] == 'R'):
        cnt2 += 1

print(min(cnt1,cnt2)+1)
        