import java.util.Stack;

public class IsPalindromeList {
    public static class ListNode{
        public int value;
        public ListNode next;
        public ListNode(int data){
            this.value = data;
        }
    }

    public boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head!=null){
            if(head.value!=stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head){
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next; //慢指针每次走一步  head->mid
            fast = fast.next.next; //快指针每次走两步  head->end
        }
        ListNode secondHalfStart = reverseList(slow.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean res = true;
        while(p1!=null && p2!=null){
            if(p1.value!=p2.value){
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



}
