public class MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode head;
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val<=list2.val){
            list1.next=mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1, list2.next);
            return list2;
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
        MergeTwoSortedLists r=new MergeTwoSortedLists();
        r.insert(1);
        r.insert(2);
        r.insert(3);
        r.insert(4);
        r.insert(5);
        r.insert(6);
        r.display(head);
        ListNode h1=head;
        r.insert(11);
        r.insert(12);
        r.insert(13);
        r.insert(14);
        r.insert(15);
        r.insert(16);
        ListNode ans=r.mergeTwoLists(h1,head);
        System.out.println("After deletion:-  ");
        r.display(ans);
    }
}
