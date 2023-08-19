while True:
    sentence = input()
    stack = []
    if(sentence == '.'):
        break      
    else:
        for i in sentence:
            if(i == '(' or i == '['):
                stack.append(i)
            elif(i == ')'):
                if(stack and stack[-1]=='('):
                    stack.pop()
                else:
                    stack.append(i) # 그냥 넣어버려서 break시키면 for문 밖에서 stack이 비어있지 않은 것으로 처리 가능
                    break
            elif(i == ']'):
                if(stack and stack[-1]=='['):
                    stack.pop()
                else:
                    stack.append(i)
                    break
        if not stack:
            print('yes')
        else:
            print('no')