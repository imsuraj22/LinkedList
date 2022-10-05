

public class LinkedListCycle {
    
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public static ListNode head;

public static boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;

        while(slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;


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
        LinkedListCycle r=new LinkedListCycle();
        r.insert(1);
        r.insert(2);
        r.insert(3);
        r.insert(4);
        r.insert(5);
        r.insert(6);
        r.display(head);
        System.out.println(hasCycle(head));
        // System.out.println("After deletion:-  ");
        // r.display(head);

    }
}
