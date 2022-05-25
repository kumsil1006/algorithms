// 프로그래머스 베스트 앨범
// https://programmers.co.kr/learn/courses/30/lessons/42579#

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        List<Integer> result = new ArrayList<>(); 
        Map<String, Integer> order = new HashMap<>();
        Map<String, List<Music>> map = new HashMap<>();
        for(int i = 0; i < plays.length; i++) {
            order.put(genres[i], order.getOrDefault(genres[i], 0) + plays[i]);
            List<Music> l = map.getOrDefault(genres[i], new ArrayList<>());
            l.add(new Music(i, plays[i]));
            map.put(genres[i], l);
        }
        List<Map.Entry<String, Integer>> entry = new ArrayList<>(order.entrySet());
        
        Collections.sort(entry, new Comparator<Map.Entry<String, Integer>> () {
           @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(String key : map.keySet()) {
            Collections.sort(map.get(key), new Comparator<Music> () {
               @Override
                public int compare(Music o1, Music o2) {
                    if(o1.num != o2.num) {
                        return o2.num - o1.num; // 높은 것 먼저
                    } else {
                        return o1.idx - o2.idx; // 낮은 것 먼저
                    }
                }
            });
        }

        
        for(Map.Entry<String, Integer> e : entry) {
            List<Music> l = map.get(e.getKey());
            for(int i = 0 ; i < l.size(); i++) {
                result.add(l.get(i).idx);
                if(i == 1) {
                    break;
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i =0 ; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    class Music {
        int idx, num;
        public Music(int i, int n) {
            this.idx = i;
            this.num = n;
        }
    }
}