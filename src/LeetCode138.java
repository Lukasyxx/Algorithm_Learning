public class LeetCode138 {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur=head;
        Node next=null;
        while (cur!=null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur=head;
        Node curCopy=null;
        while (cur!=null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random!=null?cur.random.next:null;
            cur = next;
        }
        Node result = head.next;
        cur = head;
        while (cur!=null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next!=null?next.next:null;
            cur = next;
        }
        return result;
    }
}
