// 프로그래머스 2018 KAKAO BLIND RECRUITMENT [1차] 추석 트래픽
// https://programmers.co.kr/learn/courses/30/lessons/17676
import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 1;
        List<Time> list = new ArrayList<>();
        
        for(String str : lines) {
            int h = Integer.parseInt(str.substring(11, 13)) * 3600;
            int m = Integer.parseInt(str.substring(14, 16)) * 60;
            int s = (int) (Double.parseDouble(str.substring(17, 23)) * 1000);
            int last = (int) (Double.parseDouble(str.substring(24, str.length()-1)) * 1000);
            
            int end = (h + m) * 1000 + s;
            int start = end - last + 1; // 시작 시간 포함하므로 1 더함
            list.add(new Time(start, end));
        }
        
        for(int i = 0; i < list.size(); i++) {
            int cnt = 1;
            for(int j = i+1; j <list.size(); j++) {
                if(list.get(i).end + 1000 > list.get(j).start) {
                    cnt++; // 종료 1초 이내에 시작하는 게 있는지 체크
                }
            }
            if(cnt > answer) {
                answer = cnt;
            }
        }
        return answer;
    }
    class Time {
        int start, end;
        public Time(int a, int b) {
            start = a;
            end = b;
        }
    }
}