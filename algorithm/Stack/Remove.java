// 2. 괄호문자제거
import java.util.*;
  
public class Main {
  public String solution(String str) {
    String answer = "";
    Stack<Character> stack = new Stack<>();

    for(char c : str.toCharArray()) {
      if(c == '(') {
        stack.push('(');
      } else if(c == ')' && !stack.isEmpty()) {
        stack.pop();
      } else if(stack.isEmpty()) {
        answer += c;
      }
    }
    return answer;
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.next();
    Main t = new Main();
    System.out.println(t.solution(str));
    return ;
  }
}