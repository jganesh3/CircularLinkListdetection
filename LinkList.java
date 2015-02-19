/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linklist;

/**
 *
 * @author ganesh
 */
public class LinkList {

    private  Node findtheMiddleNode() {
    
        /*
        To find the middle element in the first iteration, maintain two pointers
        slow ptr and fast ptr. while fast ptr reaches the end increment
        */
        
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
        }
        
        
        return slow;
        
    }

    private void breaktheLoop(Node loopnode) {

        /* Algo:- Keep three nodes 1: reference node i,e loopnode, ptr1 ptr2
         ptr1=head; & ptr2=loopnode

         in while check if the  ptr2->next = ptr1 (if at any time ptr2 overlaps loopnode
         break the loop
         incremenet ptr

         if(ptr2->next=ptr1)
         simply ptr2->next==null   This will break the loop


         */
        Node referene = loopnode;
        Node ptr1 = head;
        Node ptr2 = loopnode.getNext();

        while (true) {

            while (ptr2.getNext() != ptr1 && ptr2 != referene) {

                ptr2 = ptr2.getNext();

            }

            if (ptr2.getNext() == ptr1) {
                // You got it
                System.out.println("Loop in the link list is broken");
                ptr2.setNext(null);
                return;

            }

            ptr1 = ptr1.getNext();
            ptr2 = ptr2.getNext();

        }

    }

    private void checkforloop() {
        /* Use of the two pointers, slow pointer and the fast pointer,
         Slow pointer will be incremented by one node,while fast pointer will be incremented by
         two node. In any time slow and fast ptr overlaps, we found the loop
         else if fast pointer is null , we found the end of the list

         */

        Node fastptr = head;
        Node slowptr = head;

        while (fastptr != null) {

            fastptr = fastptr.getNext().getNext();
            slowptr = slowptr.getNext();

            if (slowptr == fastptr) {
                // This means loop exist, So call breakloop
                System.out.println("This link list consist of the loop");
                System.out.println("Breaking this loop");
                breaktheLoop(fastptr);
            }

        }

        System.out.println("This Linked list doesn't contain any node");

    }

    private Node head;

    public LinkList() {
        this.head = null;
    }

    public void addNode(int data) {
        this.head = addNode(data, head);
    }

    public void creatCircle() {

        Node n = head;
        Node temp = head;
        while (temp.getNext() != null) {

            temp = temp.getNext();
        }

        System.out.println("Last element in link list is -->" + temp.getData());

        n = n.getNext().getNext();

        //create link by setting last node address to this node
        temp.setNext(n);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("This is Link list class");
        boolean isLoop;

        LinkList list = new LinkList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);
        list.addNode(60);
        list.addNode(70);
         list.addNode(80);
        list.creatCircle();
        //list.display();
        list.checkforloop();
        //list.display();

        //list.deletebefore(10); // i.e. delete node 30
       // list.deleteAfter(10); // i.e. remove 50
       
        Node middle=list.findtheMiddleNode();
        System.out.println("Middle ptr is"+middle.getData());
        
        list.reverse();
        list.display();

    }

    private Node addNode(int data, Node node) {

        if (node == null) {
            return new Node(data);
        }

        node.setNext(addNode(data, node.getNext()));

        return node;

    }

    public void display() {

        display(head);

    }

    private void display(Node node) {

        if (node == null) {
            return;
        } else {

            System.out.println(node.getData() + " ");
            display(node.getNext());

        }

    }

    private void deletebefore(int i) {
        
        //check if the i== head->data
        if(head.getData()==i)
        {
            System.out.println("No node present before");
            return;
        }
        
    
        Node runner=head;
        Node parent=null;
        while(runner.getNext().getData()!=i && runner.getNext()!=null){
            parent=runner;
            runner=runner.getNext();
        }
        
        //Simply change the pointers
        if(parent!=null)
        parent.setNext(runner.getNext());
        
        
    }

    private void deleteAfter(int i) {
    
        Node runner=head;
        while(runner.getData()!=i && runner.getNext()!=null){
            runner=runner.getNext();
        }
        
        
        if(runner.getNext()==null)
        {
            System.out.println("No node present after");
            return;
        }
        
        //Simply change the pointers
        runner.setNext(runner.getNext().getNext());
    
    }

    private void reverse() {
      
      reverse(head);   
        
    }

    private void reverse(Node node) {
    
        if (node.getNext() == null) {
            //set your new head
            this.head=node;
            return;
        } else {

           // System.out.println(node.getData() + " ");
            reverse(node.getNext());
            node.getNext().setNext(node);
            node.setNext(null);

        }
        
    
    }
}
