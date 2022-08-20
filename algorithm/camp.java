import java.util.*;

class Camp {
  public static void main(String[] args) {
    Camp c = new Camp();
    int[] input = {1, 2, 3, 3, 3, 3, 4, 4};
    for(int i : c.solution(input)) {
      System.out.println(i);
    }
  }

  public int[] solution(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    
    for(int i : arr) {
      map.put(i, map.getOrDefault(i, 0)+1);
    }
    for(Integer key : map.keySet()) {
      int value = map.get(key);
      if(value > 1) {
        list.add(value);
      }
    }
    if(list.size() == 0) {
      int[] answer = { -1 };
      return answer;
    }
  
    int[] answer = new int[list.size()];
    for(int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    return answer;
  }
  
}
