// 백준 1697 숨바꼭질
// https://www.acmicpc.net/problem/1697
import java.util.*;

class Main {
    static int[] ch;
    static int target1, target2;

    public int BFS(int v) {
        int[] move = {1, -1, 2};
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        int L = 0; // 거리(초)

        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0 ; i < len; i++) {
                int x = q.poll();
                if(x == target2) {
                    return L;
                }
                for(int j = 0; j < move.length; j++) {
                    int nx = j == 2 ? 2*x : x+move[j];
                    // 인덱스 범위 주의해야 함!
                    // target1보다 target2가 더 작은 경우 존재함.
                    if(nx >= 0 && nx < 100001 && ch[nx] == 0) {
                        q.add(nx);
                        ch[nx] = 1;
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main t = new Main();
        target1 = in.nextInt();
        target2 = in.nextInt();

        ch = new int[100001];
        ch[target1] = 1;
      
        System.out.println(t.BFS(target1));
    }
}