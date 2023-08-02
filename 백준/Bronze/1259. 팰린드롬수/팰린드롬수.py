
check = True                         

while True:
    num = input()
    if(num == "0"):
        break
    elif(num == num[::-1]):  #[::-1] 하면 역순으로 정렬해준대
        print("yes")
    else:
        print("no")