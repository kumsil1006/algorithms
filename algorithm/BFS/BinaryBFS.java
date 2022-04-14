// 이진트리 순회(BFS): 최단거리 (Queue)
// 레벨탐색!
// root에서 한 번만에 갈 수 있는 노드들 --> 두 번 만에 --> 세 번 만에 --> ... 전부 다 탐색
import java.util.*;

public class Main {
  Node root;
  public void BFS(Node root){ 
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int L = 0;
    while(!q.isEmpty()) {
      int len = q.size();
      System.out.print(L + ": ");
      for(int i = 0; i < len; i++) {
        Node cur = q.poll();
        System.out.print(cur.data + " ");
        if(cur.lt != null) q.add(cur.lt);
        if(cur.rt != null) q.add(cur.rt);
      }
      L++;
      System.out.println();
    }
    
  } 
  public static void main(String args[]) { 
        Main tree=new Main(); 
        tree.root=new Node(1); 
        tree.root.lt=new Node(2); 
        tree.root.rt=new Node(3); 
        tree.root.lt.lt=new Node(4); 
        tree.root.lt.rt=new Node(5); 
		    tree.root.rt.lt=new Node(6); 
        tree.root.rt.rt=new Node(7);
        tree.BFS(tree.root); 
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