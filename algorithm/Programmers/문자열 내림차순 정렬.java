/*
* 프로그래머스 - 문자열 내림차순 정렬
* https://programmers.co.kr/learn/courses/30/lessons/12917#
*/
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<Character> list = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        
        Collections.sort(list, new Comparator<Character> () {
            public int compare(Character o1, Character o2) {
                if(Character.isUpperCase(o1) && !Character.isUpperCase(o2)) {
                  return 1;  
                } else if(!Character.isUpperCase(o1) && Character.isUpperCase(o2)) {
                    return -1;
                } else if(o1 > o2) {
                    return -1;    
                }
                return 1;
            }
        });
        
        for(Character i : list) {
            answer += i;
        }
        return answer;
    }
}