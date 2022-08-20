// 백준 11723 집합
// https://www.acmicpc.net/problem/11723
import java.util.*;
import java.io.*;

class Main {
  static Set<String> set;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Main T = new Main();
    set = new HashSet<>();
    int n = Integer.valueOf(br.readLine().split(" ")[0]);
    
    for(int i = 0; i < n; i++) {
      String[] s = br.readLine().split(" ");
      String type = s[0];
      
      if("all".equals(type)) {
        T.all();
        continue;
      } else if("empty".equals(type)) {
        set.clear();
        continue;
      }
      String value = s[1];

      if("add".equals(type)) {
        set.add(value);
      } else if("remove".equals(type) && set.contains(value)) {
        set.remove(value)  ;
      } else if("check".equals(type)) {
        int print = set.contains(value) ? 1 : 0;
        sb.append(print+"\n");
      } else if("toggle".equals(type)) {
        if(set.contains(value)) {
          set.remove(value);
        } else {
          set.add(value);
        }
      }
      
    }
  System.out.println(sb.toString());
  }

  public void all() {
    set.clear();
    for(int i = 1; i < 21; i++) {
      set.add(Integer.toString(i));
    }
  }
}