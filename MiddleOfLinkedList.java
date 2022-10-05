        
public class MiddleOfLinkedList {

    public ListNode head;
    class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        }
        
    /*  ------ BRUTE FORCE APPROACH---------
    public ListNode middleNode(ListNode head) {
        int n=size(head);
        for(int i=0; i<n/2; i++){
            head=head.next;
        }
        return head;
    }

    int size(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;

        }
        return count;
    }*/

    //OPTIMIZED SOLUTION
    
    public ListNode middleNode() {
        ListNode slowPtr=head, fastPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        return slowPtr;
    }

    void insert(int item){
        ListNode ptr=new ListNode();
        ptr.val=item;
        if(head==null){
            head=ptr;
        }else{
            ListNode temp=head;
            head=ptr;
            head.next=temp;
        }

    }
    public static void main(String[] args) {
        MiddleOfLinkedList m=new MiddleOfLinkedList();
        
        //MiddleOfLinkedList m=new MiddleOfLinkedList();
        m.insert(1);
        m.insert(2);
        m.insert(3);
        m.insert(4);
        m.insert(5);
        m.insert(6);
       ListNode node=m.middleNode();
       System.out.println(node.val);

    }
}
