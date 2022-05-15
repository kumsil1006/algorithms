// 프로그래머스 튜플 (2019 카카오 개발자 겨울 인턴십)
// https://programmers.co.kr/learn/courses/30/lessons/64065
import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.substring(2, s.length()-2).split("},\\{"); // parse
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            String[] strArr = arr[i].split(",");
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j < strArr.length; j++) {
               l.add(Integer.parseInt(strArr[j]));  
            }
            list.add(l);
        }
        // 원소 개수 순으로 정렬
        Collections.sort(list, new Comparator<List<Integer>> () {
           @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        for(List<Integer> l : list) {
            for(int i : l){
                if(!result.contains(i)) result.add(i);
            }  
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}