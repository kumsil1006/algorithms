// 백준 등수 구하기
import java.util.*;

class Main {
  static int n, p;
  static int newScore;
  static int[] scores;
  
  public int solution() {
    int rank = 1;
    Map<Integer, Integer> map = new HashMap<>();
    for(int l : scores) {
      map.put(l, map.getOrDefault(l, 0)+1);
    }
    map.put(newScore, map.getOrDefault(newScore, 0)+1);

    List<Map.Entry<Integer, Integer>> entry = new ArrayList<>(map.entrySet());

    Collections.sort(entry, new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return Integer.compare(o2.getKey(), o1.getKey());
      }
    });

    for(Map.Entry<Integer, Integer> e : entry) {
      int s = rank + e.getValue();
      if(s > p+1) {
        return -1;
      }
      if(newScore == e.getKey()) {
        break;
      }
      rank += e.getValue();
    } 
    
    return rank;
  }
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Main T = new Main();

    n = kb.nextInt();
    newScore = kb.nextInt();
    p = kb.nextInt();

    scores = new int[n];
    
    for(int i = 0; i < n; i++) {
      scores[i] = kb.nextInt();
    }
  
    System.out.println(T.solution());
  }
}