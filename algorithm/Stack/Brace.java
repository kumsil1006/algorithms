import java.util.*;
  
public class Main {
  public String solution(String str) {
    Stack<Character> stack = new Stack<>();
    for(char c : str.toCharArray()) {
      if(c == '(') stack.push('(');
      else if(stack.size() == 0) return "NO"; 
      else {
        char tmp = stack.pop();
      }
    }
    if(stack.size() != 0) return "NO";
    
    return "YES";
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String input = in.next();
    Main m = new Main();
    System.out.println(m.solution(input));
    return ;
  }
}