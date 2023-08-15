while True:
    li = list(map(int,input().split()))
    sum_li = sum(li)
    maxval = max(li)
    li.remove(maxval)

    if(sum_li == 0):
        break
    elif(maxval**2 == li[0]**2 + li[1]**2):
        print("right")
    else:
        print("wrong")


