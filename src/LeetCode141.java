public class LeetCode141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow!=fast) {
            if(fast.next==null || fast.next.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
