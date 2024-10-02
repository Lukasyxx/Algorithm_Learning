public class SmallerEqualBigger {
    public static class ListNode{
        public int value;
        public ListNode next;
        public ListNode(int data){
            this.value = data;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode SH = null, ST = null, EH = null, ET = null, BH = null, BT = null;
        ListNode next = null;
        while (head!=null) {
            next = head.next;
            head.next = null;
            if(head.value < x){
                if(SH==null){
                    SH = head;
                    ST = head;
                }
                else{
                    ST.next = head;
                    ST = head;
                }
            }
            else if(head.value == x){
                if(EH==null){
                    EH = head;
                    ET = head;
                }
                else{
                    ET.next = head;
                    ET = head;
                }
            }
            else{
                if(BH==null){
                    BH = head;
                    BT = head;
                }
                else{
                    BT.next = head;
                    BT = head;
                }
            }
            head = next;
        }
        if(ST!=null){  //如果有<区域
            ST.next = EH;
            ET = ET==null?ST:ET;
        }
        if(ET!=null){  //如果<区域和=区域不是都没有
            ET.next = BH;
        }
        return SH!=null?SH:(EH!=null?EH:BH);
    }
}
