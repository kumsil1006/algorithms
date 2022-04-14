// 5. 이진트리순회(DFS)
import java.util.*;

public class Main {
  Node root;
  public void DFS(Node root) {
    if(root==null) return;
    else {
      System.out.print(root.data + " "); // 여기에 print하면 전위순회
      DFS(root.lt); // 왼쪽으로 이동
      // 여기에 print하면 중위순회
      DFS(root.rt); // 오른쪽으로 이동
      // 여기에 print하면 후위순회
    }
  }
  public static void main(String[] args) {
    Main tree = new Main();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    tree.root.rt.lt = new Node(6);
    tree.root.rt.rt = new Node(7);
    tree.DFS(tree.root);
  }
}

public class Node {
  int data;
  Node lt, rt;
  public Node(int val) {
    data = val;
    lt = rt = null;
  }
}