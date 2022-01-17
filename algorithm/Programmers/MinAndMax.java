/*
* 프로그래머스 연습문제: 최댓값과 최솟값
* https://programmers.co.kr/learn/courses/30/lessons/12939
*/

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        List<Integer> list = new ArrayList<>();
        
        for(String i : arr) {
            list.add(Integer.parseInt(i));
        }
        Collections.sort(list);
        answer = list.get(0).toString() + " " + list.get(list.size()-1).toString();
        return answer;
    }
}