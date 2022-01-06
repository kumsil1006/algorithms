// 프로그래머스 실패율

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] people = new int[N+2];
        Map<Integer, Double> notFinish = new TreeMap<>();
        
        for(int i = 0; i < stages.length; i++) {
            int temp = stages[i];
            
            for(int j = 1; j <= temp; j++) {
                people[j] += 1;    
            }
        }

        // 스테이지에 도달했으나 아직 클리어 x
        for(int i = 1; i < people.length-1; i++) {
            if(people[i] != 0) {
                notFinish.put(i, (double)(people[i] - people[i+1]) / people[i]);    
            } else {
                // 해당 스테이지에 아무도 도착하지 못 한 경우
                notFinish.put(i, 0.0);
            }
        }

        List<Integer> listKeySet = new ArrayList<>(notFinish.keySet());
        Collections.sort(listKeySet, (o1, o2) -> (notFinish.get(o2).compareTo(notFinish.get(o1))));
        
        int i = 0;
        for(int key : listKeySet) {    
            answer[i] = key;
            i += 1;
        }
        
        return answer;
    }
}