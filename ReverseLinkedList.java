import java.util.Stack;

public class ReverseLinkedList {
    public static ListNode head;
    static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        }
        
           
        //---- USING STACK------ 
        void reverseStack(){
            Stack<ListNode> stack=new Stack<>();
            
            ListNode ptr=head;
           

            while(ptr.next!=null){
                stack.push(ptr);
                ptr=ptr.next;
            }
             
            head=ptr;
            
            while(!stack.isEmpty()){
                ptr.next=stack.pop();
                ptr=ptr.next;
            }
            ptr.next=null;


        }

        //----- ITERATIVE WAY------ 
        void reverseIteration(){
            ListNode prev=null;
            ListNode current=head;
            ListNode next;

            while(current!=null){
                next=current.next;
                current.next=prev;

                prev=current;
                current=next;
            }
            head=prev;
        }

        ListNode reverseRecursion(ListNode head){
            if(head==null || head.next==null){
                return head;
            }
            ListNode newNode=reverseRecursion(head.next);
            head.next.next=head; //2nd ekement is pointing to 1st
            head.next=null;

            return newNode;
            
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
        ReverseLinkedList r=new ReverseLinkedList();
        r.insert(1);
        r.insert(2);
        r.insert(3);
        r.insert(4);
        r.insert(5);
        r.insert(6);
        r.display(head);
        r.reverseStack();
        System.out.println("Using Stack : ");
        r.display(head);
        r.reverseIteration();
        System.out.println("Using Iteration : ");
        r.display(head);
        ListNode node=r.reverseRecursion(head);
        System.out.println("Using Recursion");
        r.display(node); 
        
    }
}
