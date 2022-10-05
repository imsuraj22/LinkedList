public class RemoveElement {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode head;
    
    public ListNode removeElements(ListNode head, int num) {
        if(head==null){
            return null;
        }
        head.next=removeElements(head.next, num);
        return head.val==num?head.next:head;

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
        RemoveElement r=new RemoveElement();
        r.insert(1);
        r.insert(2);
        r.insert(3);
        r.insert(4);
        r.insert(5);
        r.insert(6);
        r.display(head);
        ListNode ans=r.removeElements(head,5);
        System.out.println("After deletion:-  ");
        r.display(head);
    }
}
