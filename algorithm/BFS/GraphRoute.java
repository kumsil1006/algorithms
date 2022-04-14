// 그래프 최단거리(BFS) --> 레벨탐색

import java.util.*;

public class FindShortCut {
    static int[] ch;
    static int[] answer;
    static int L = 0, n = 0, m = 0;
    static ArrayList<ArrayList<Integer>> graph;

    public void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        ch[v] = 1;
        answer[v] = L++;

        while(!q.isEmpty()) {
            int x = q.poll();
            boolean flag = false;
            ArrayList<Integer> tmp = graph.get(x);
            for(int nx : tmp) {
                if (ch[nx] == 0) {
                    ch[nx] = 1;
                    answer[nx] = L;
                    q.offer(nx);
                    flag = true;
                }
            }
            if(flag) L++;
        }
    }

    public static void main(String[] args) {
        FindShortCut T = new FindShortCut();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<>();
        for(int i = 0; i <=n; i++) {
            graph.add(new ArrayList<Integer>()); // 객체생성!
        }
        ch = new int[n+1];
        answer = new int[n+1];
        for(int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b); // 인접리트스
        }
        T.BFS(1);
        for(int i=2; i <=n; i++) {
            System.out.println(i + ": " + answer[i]);
        }

    }
}
