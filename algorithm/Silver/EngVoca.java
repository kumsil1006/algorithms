// 백준 20920 영단어 암기는 괴로워
// https://www.acmicpc.net/problem/20920
import java.util.*;
import java.io.*;

class Main {
  static int n, m;
  static Map<String, Integer> map;
  
  public void solution() {
    StringBuilder sb = new StringBuilder();
    
    List<Map.Entry<String, Integer>> entry = new ArrayList<>(map.entrySet());
    Collections.sort(entry, new Comparator<Map.Entry<String, Integer>> () {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        // 1. 자주 나올수록
        if(o1.getValue() != o2.getValue()) {
          return o2.getValue() - o1.getValue();
        }
        // 2. 길이가 긴 순
        int len1 = o1.getKey().length();
        int len2 = o2.getKey().length();
        if(len1 != len2) {
          return len2 - len1;
        }
        // 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
        return o1.getKey().compareTo(o2.getKey());
      }
    });
    for(Map.Entry<String, Integer> e : entry) {
      sb.append(e.getKey() + " \n");
    }
    System.out.println(sb.toString());
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    map = new HashMap<>();
    
    String[] input = br.readLine().split(" ");
    
    n = Integer.valueOf(input[0]);
    m = Integer.valueOf(input[1]);
    
    Main T = new Main();

    for(int i = 0; i < n; i++) {
      String voca = br.readLine();
      if(voca.length() >= m) {
        map.put(voca, map.getOrDefault(voca, 0) + 1);
      }
    }

    T.solution();
  }
} 