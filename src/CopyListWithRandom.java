import java.util.HashMap;

public class CopyListWithRandom {
    public static class ListNode{
        public int value;
        public ListNode next;
        public ListNode rand;
        public ListNode(int data){
            this.value = data;
        }
    }
    public static ListNode copyListWithRandom1(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        ListNode cur = head;
        while(cur!=null){
            map.put(cur, new ListNode(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
    public static ListNode copyListWithRandom2(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur = head;
        ListNode next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = new ListNode(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        ListNode curCopy = null;
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand!=null?cur.rand.next:null;
            cur = next;
        }
        ListNode result = head.next;
        cur = head;
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next!=null?next.next:null;
            cur = next;
        }
        return result;
    }
}