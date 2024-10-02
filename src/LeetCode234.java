public class LeetCode234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalfStart = reverseList(slow.next);
        boolean res = true;
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        while(p1!=null && p2!=null){
            if(p1.val != p2.val){
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        slow.next = reverseList(secondHalfStart);
        return res;
    }
    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        LeetCode234 l = new LeetCode234();
        ListNode head = l.new ListNode(1);
        head.next = l.new ListNode(2);
        head.next.next = l.new ListNode(4);
        head.next.next.next = l.new ListNode(3);
        head.next.next.next.next = l.new ListNode(4);
        head.next.next.next.next.next = l.new ListNode(2);
        head.next.next.next.next.next.next = l.new ListNode(1);
        System.out.println(l.isPalindrome(head));
    }
}
