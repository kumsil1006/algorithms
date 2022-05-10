// 프로그래머스 124 나라의 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12899

import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] nums = { "4", "1", "2" };
        
        while(n >= 1) {
            answer = nums[n%3] + answer;
            System.out.println(answer + " ");
            n = (n-1) / 3;
        }
        
        return answer;
    }
}