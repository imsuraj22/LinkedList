import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReorderList {
    public static ListNode head;

    public void reorderList(ListNode head) {
        ListNode l1=head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;
        ListNode l2=reverse(slow);
        merge(l1,l2);
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode current=head;
        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    void merge(ListNode l1, ListNode l2){
        while(l1!=null){
            ListNode l1_next=l1.next;
            ListNode l2_next=l2.next;

            l1.next=l2;
            if(l1_next==null){
                break;
            }
            l2.next=l1_next;
            l1=l1_next;
            l2=l2_next;
        }
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
        ReorderList r=new ReorderList();
        r.insert(1);
        r.insert(2);
        r.insert(3);
        r.insert(4);
        r.insert(5);
        r.insert(6);
        r.display(head);
        r.reorderList(head);
        System.out.println("After Arranging :-  ");
        r.display(head);

    }
}
