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
class Node {
    
private Node next;
private int data;

public Node(int data)
{
    this.next=null;
    this.data=data;
}

public Node getNext()
{
    return this.next;
}

public int  getData(){
    return this.data;
}

public void setNext(Node n)
{
    this.next=n;
    
}



}
