n = int(input())

word = []
lenword = []

sortedword = []
for _ in range(n):
    word.append(input())

setword = list(set(word)) #중복을 허용하지 않으려면 set으로  # set으로 저렇게 하면 {}로 나와서 list로 한 번 더 감싸줘야함 

for i in setword:
    lenword.append( (len(i),i) )  # 이렇게 리스트에 (a,b)쌍을 통으로 넣으려면 괄호로 묶어서 넣어줘야함
 
sortedword = sorted(lenword)

for len,word in sortedword:
    print(word)
    
