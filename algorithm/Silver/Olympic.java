// 백준 8979: 올림픽
import java.util.*;

class Main {
  public int solution(int n, int k, int[][] input) {
    List<Medal> list = new ArrayList<>();
    int rank = 0;
    int cnt = 0;
    Medal last = new Medal(0, 0, 0, 0);
    for(int i = 0; i < input.length; i++) {
      list.add(new Medal(input[i][0], input[i][1], input[i][2], input[i][3]));
    }

    Collections.sort(list, new Comparator<Medal>() {
      @Override
      public int compare(Medal o1, Medal o2) {
        if(o1.gold != o2.gold) {
          return o2.gold - o1.gold;
        }
        if(o1.silver != o2.silver) {
          return o2.silver - o1.silver;
        }
        return o2.bronze - o1.bronze;
      }
    });

    for(int i = 0; i < list.size(); i++) {
      if(list.get(i).nation == k) {
        return rank == 0 ? 1 : rank + cnt;
      } else if(isEqual(list.get(i), last)) {
        // 동점인 경우
        cnt += 1;
      } else {
        last = list.get(i);
        rank = rank + cnt + 1;
        cnt = 0;
      }
    }
    return -1;
  }
  public boolean isEqual(Medal m1, Medal m2) {
    return m1.gold == m2.gold && m1.silver == m2.silver && m1.bronze == m2.bronze;
  }
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Main T = new Main();
    
    int n = kb.nextInt();
    int k = kb.nextInt();

    int[][] input = new int[n][4];
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < 4; j++) {
        input[i][j] = kb.nextInt();  
      }
    }

    System.out.println(T.solution(n, k, input));
  }

  class Medal {
    int nation, gold, silver, bronze;

    public Medal(int n, int g, int s, int b) {
      this.nation = n;
      this.gold = g;
      this.silver = s;
      this.bronze = b;
    }
  }
}