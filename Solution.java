class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
     
public class Solution {
    public static ListNode head;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<n;i++){
            if(fast.next==null){
                if(i==n-1){
                    head=head.next;
                }
                return head;
            }
            fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        if(slow.next!=null){
            slow.next=slow.next.next;
        }
        return head;
    }
    void insert(int item){
        ListNode ptr=new ListNode();
        ptr.val=item;
        ListNode temp=head;
        if(head==null){
            head=ptr;
        }else{
            
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=ptr;
            
        }

    } 
    
    void display(ListNode head){
        ListNode current=head;
        if(head==null)
            System.out.println("Empty list");

        while(current!=null){
            System.out.print("-> "+current.val);
            current=current.next;
        }    
        System.out.println();
    }
    
    public static void main(String[] args) {
        Solution r=new Solution();
        r.insert(1);
        r.insert(2);
        r.insert(3);
        r.insert(4);
        r.insert(5);
        r.insert(6);
        r.display(head);
        ListNode ans=r.removeNthFromEnd(head,2);
        System.out.println("After deletion:-  ");
        r.display(head);

    }
}
