# 프로그래머스 키패드 누르기

position = {
    '1' : (0, 0),
    '2' : (0, 1),
    '3' : (0, 2),
    '4' : (1, 0),
    '5' : (1, 1),
    '6' : (1, 2),
    '7' : (2, 0),
    '8' : (2, 1),
    '9' : (2, 2),
    '*' : (3, 0),
    '0' : (3, 1),
    '#' : (3, 2)   
}

def solution(numbers, hand):
    answer = ''
    prev = (position.get('*'), position.get('#'))
    for i in numbers:
        a, p = isRightLeft(prev, str(i), hand)
        answer += a
        prev = p
    return answer

def isRightLeft(prev, num, hand):
    rights = ['3', '6', '9', '#']
    lefts = ['1', '4', '7', '*']
    
    if num in rights:
        prev = (prev[0], position.get(num))
        return 'R', prev
    elif num in lefts:
        prev = (position.get(num), prev[1])
        return 'L', prev
    
    now = position.get(num)
    
    l_distance = abs(prev[0][0] - now[0]) + abs(prev[0][1] - now[1])
    r_distance = abs(prev[1][0] - now[0]) + abs(prev[1][1] - now[1])
    
    if (l_distance == r_distance and hand == 'right') or (l_distance > r_distance):
        prev = (prev[0], position.get(num))
        return 'R', prev
    elif l_distance < r_distance or l_distance == r_distance:
        prev = (position.get(num), prev[1])
        return 'L', prev
    
    
