# BOJ 4949번 균형잡힌 세상

def solution(string):
  stack = []
  pair = { ')' : '(', ']' : '[' }

  for i in string:
    if i == '(' or i == '[':
      stack.append(i)
    elif (i == ']' or i == ')') and len(stack) == 0:
      return False
    elif (i == ']' or i == ')') and stack[-1] != pair.get(i):
      return False
    elif i == ']' or i == ')':
      stack.pop()
  
  if len(stack) > 0:
    return False
  return True


while True:
  input_str = input()

  if input_str == '.':
    break
   
  print('yes' if solution(input_str) == True else 'no')
    
  
