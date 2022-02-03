// 4. 단어 뒤집기

import java.util.*;
  
public class Main {
  public String[] solution(int size, String[] str) {
    String[] answer = new String[size];
    for(int i = 0; i < str.length; i++) {
      StringBuffer sb = new StringBuffer(str[i]);
      answer[i] = sb.reverse().toString();
    }
    
    return answer;
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    String[] input = new String[n];
    for(int i = 0; i < n; i++) {
      input[i] = in.next();
    }
    String[] answer = m.solution(n, input);
    for(int i = 0; i < n; i++) {
      System.out.println(answer[i]);
    }
    
    return ;
  }
}