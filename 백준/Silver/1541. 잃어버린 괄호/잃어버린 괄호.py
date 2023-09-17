Alist = input().split('-')


AnsList = []
for a in Alist:
    Asum = 0
    Blist = []
    Blist = a.split('+')
    for b in Blist:
        Asum += int(b) 
    AnsList.append(Asum)

first = AnsList[0]

for b in range(1,len(AnsList)):
    first -= AnsList[b]
print(first)