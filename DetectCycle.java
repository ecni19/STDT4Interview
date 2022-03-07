public class DetectCycle {
  static class Node {
    int data;
    Node next;
    Node(int d) {
      data = d;
      next = null;
    }
  }
  
  public static boolean hasCycle(Node head) {
    if(head == null) {
      return false;
    }
    Node slow = head;
    Node fast = head.next;
    
    // if no cycle, fast node will detect end of list quicker
    while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) {
            return true;
        }
    }
    return false;
  }
  private static boolean TestBigCycle() {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    Node n8 = new Node(8);
    Node n9 = new Node(9);
    Node n10 = new Node(10);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;
    n8.next = n9;
    n9.next = n10;
    n10.next = n2;
    return DetectCycle.hasCycle(n1);
  }
  private static boolean NoCycle() {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = null;

    return DetectCycle.hasCycle(n1);
  }
  private static boolean NullElement() {
    return DetectCycle.hasCycle(null);
  }
  private static boolean SingleElement() {
    Node n1 = new Node(1);

    return DetectCycle.hasCycle(n1);
  }
  public static void main(String[] args) {
    System.out.println(TestBigCycle());
    System.out.println(NullElement());
    System.out.println(SingleElement());
    System.out.println(NoCycle());
  }
}