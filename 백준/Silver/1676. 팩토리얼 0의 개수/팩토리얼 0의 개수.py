#팩토리얼 구현

def factorial(n):
    if(n==1):
        return 1
    elif(n==0):
        return 0
    else:
        return n * factorial(n-1)
    
num = int(input())
result = str(factorial(num))
reverse_result = result[::-1]

count = 0
for b in reverse_result:
    if(len(reverse_result)==1):
        break
    elif(b=='0'):
        count += 1
    else:
        break
print(count)

