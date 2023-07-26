inputList = []

for i in range(10):
    n = int(input())
    inputList.append(n % 42)
    
listSet = list(set(inputList))
print(len(listSet))