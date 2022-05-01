// 프로그래머스 숫자의 표현
// https://programmers.co.kr/learn/courses/30/lessons/12924
// 문제 풀이 아이디어: Sliding Window
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0, lt = 1, rt = 1, sum = 0;
        // lt: 시작하는 값
        // rt: 끝나는 값
        // lt + (lt+1) + (lt+2) + .... + rt
        while(rt <= n && lt <= n) {
            if(rt == lt) {
                sum = lt;
            }
            if(sum < n) {
                sum += ++rt;
            } else if(sum > n) {
                sum -= lt++;
            } else {
                answer++;
                sum += ++rt;
                sum -= lt++;
            }
        }
        
        return answer;
    }
}