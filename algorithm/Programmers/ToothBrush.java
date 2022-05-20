// 프로그래머스 다단계 칫솔 판매
// https://programmers.co.kr/learn/courses/30/lessons/77486
import java.util.*;

class Solution {
    List<Node> nodes;
    int[] answer;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        nodes = new ArrayList<>();
        
        for(int i = 0; i < enroll.length; i++) {
            int ref = "-".equals(referral[i]) ? -1 : getIdx(referral[i], enroll);
            
            Node newNode = new Node(enroll[i], i, ref);
            nodes.add(newNode);
        }
        
        for(int i = 0; i < seller.length; i++) {
            DFS(getIdx(seller[i], enroll), amount[i]*100);
        }
        return answer;
    }

    public void DFS(int idx, int money) {
        if(idx == -1) {
            // 추천인이 없는 경우
            return ;
        }
        Node curr = nodes.get(idx);

        double next = money * 0.1;
        if(next < 1) {
            // 1원 이하인 경우 모두 갖는다.
            answer[idx] += money;
            return ;
        }
        answer[idx] += (money - (int) next);
        DFS(curr.ref, (int) next);
    }
    
    public int getIdx(String name, String[] enroll) {
        int idx = -1;
        
        for(int i = 0; i < enroll.length; i++) {
            if(name.equals(enroll[i])) {
                idx = i;
                break;
            }
        }
        return idx;
    }
    class Node {
        String name;
        int idx;
        int ref;
        
        public Node(String name, int idx, int ref) {
            this.name = name;
            this.idx = idx;
            this.ref = ref;
        }
    }
}