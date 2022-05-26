// https://programmers.co.kr/learn/courses/30/lessons/12900#
// 프로그래머스 2 X n 타일링

import java.util.*;

class Solution {
    List<Integer> list;
    long sum = 0;
    public int solution(int n) {
        int answer = 0;
        list = new ArrayList<>();
        for(int i = 0 ; i < 3; i++) {
            list.add(i);
        }
        
        for(int i = 0; i < n; i++) {
            fibo(i);
        }
        sum = list.get(n-2) + list.get(n-1);
        answer = (int)(sum % 1000000007);
        return answer;
    }
    
    public void fibo(int n) {
        if(n > 2) {
            long result = list.get(n-1) + list.get(n-2);
            list.add((int)(result % 1000000007));
        }
    }
}