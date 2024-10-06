public class FindFirstIntersectNode {
    public static class ListNode{
        public int value;
        public ListNode next;
        public ListNode rand;
        public ListNode(int data){
            this.value = data;
        }
    }
    public static ListNode getIntersectNode(ListNode head1, ListNode head2){
        if(head1==null || head2==null){
            return null;
        }
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        if(loop1==null && loop2==null){
            return noLoop(head1, head2);
        }
        if(loop1!=null && loop2!=null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }
    // 找到链表第一个入环节点，如果无环，返回null
    public static ListNode getLoopNode(ListNode head){
        if(head==null || head.next==null || head.next.next==null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow!=fast){
            if(fast.next==null || fast.next.next==null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head; 
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    // 如果两个链表都无环，返回第一个相交节点，如果不相交，返回null
    public static ListNode noLoop(ListNode head1, ListNode head2){
        if(head1==null || head2==null){
            return null;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int n = 0;
        while(cur1.next!=null){
            n++;
            cur1 = cur1.next;
        }
        while(cur2.next!=null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1!=cur2){
            return null;
        }
        cur1 = n>0?head1:head2; //谁长，谁的头变cur1
        cur2 = cur1==head1?head2:head1; //谁短，谁的头变cur2
        n = Math.abs(n);
        while(n!=0){
            n--;
            cur1 = cur1.next;
        }
        while(cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    //如果两个有环链表，返回第一个相交节点，如果不相交，返回null
    public static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2){
        ListNode cur1 = null, cur2 = null;
        // 入环节点相同
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1.next!=null){
                n++;
                cur1 = cur1.next;
            }
            while(cur2.next!=null){
                n--;
                cur2 = cur2.next;
            }
            if(cur1!=cur2){
                return null;
            }
            cur1 = n>0?head1:head2; //谁长，谁的头变cur1
            cur2 = cur1==head1?head2:head1; //谁短，谁的头变cur2
            n = Math.abs(n);
            while(n!=0){
                n--;
                cur1 = cur1.next;
            }
            while(cur1!=cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        else{
            cur1 = loop1.next;
            while(cur1!=loop1){
                if(cur1==loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
