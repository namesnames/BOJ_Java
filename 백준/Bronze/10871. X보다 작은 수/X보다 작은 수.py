a,b = map(int,input().split())

inputList = list(map(int,input().split()))
answerList = []
for i in range(len(inputList)):
    if(inputList[i] < b):
        answerList.append(inputList[i])

for j in range(len(answerList)):
    print(answerList[j],end=" ")
        
