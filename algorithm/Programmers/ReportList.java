// (카카오) 신고 결과 받기
// https://programmers.co.kr/learn/courses/30/lessons/92334#

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> userMap = new HashMap<>();
        Map<String, Integer> reportMap = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++) {
            userMap.put(id_list[i], new HashSet<>());
            reportMap.put(id_list[i], 0);
        }
        
        for(String r : report) {
            String[] names = r.split(" ");
            Set<String> set = userMap.get(names[1]);
            set.add(names[0]);
            userMap.put(names[1], set);
        }
        
        for(String str : userMap.keySet()) {
            Set<String> set = userMap.get(str);
            if(set.size() >= k) {
                for(String r : set) {
                    reportMap.put(r, reportMap.get(r) + 1);
                }
            }
        }
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = reportMap.get(id_list[i]);
        }
        return answer;
    }
}