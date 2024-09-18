package PatternQuestions;

import java.util.Scanner;

public class LinkedListDemo
{
     class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;

        }

    }
    public Node head;
    public static void main(String [] args)
    {
        LinkedListDemo obj=new LinkedListDemo();
        obj.addNode(11);
        obj.addNode(12);
        obj.addNode(13);
        obj.addNode(14);
        obj.addNode(15);
        obj.addNode(16);

        obj.displayList();

        obj.insertAtIndex(3,20, obj.head);
        obj.displayList();
        obj.insertAtPosition(3,21, obj.head,null);
        obj.displayList();
        LinkedListDemo obj2=new LinkedListDemo();
        Node list=obj2.createList();
        obj2.displayList();



    }
    public  Node addNode(int data)
    {
        Node newNode= new Node(data);
        if(this.head==null)
        {
            head=newNode;
        }
        else
        {
            //traverse to add at last
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            //reached at the last node
            temp.next=newNode;

        }
        return this.head;
    }
    public void displayList()
    {
        if(head==null)
        {
            return;
        }
        Node temp=this.head;
        while (temp!=null)
        {
            System.out.print("|"+temp.data +"|->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }

    public Node insertAtIndex(int index,int data,Node current)
    {
        // 11|->|12|->|13|->|14|->|15|->|16|->NULL
        //base case
        if(index==0)
        {
            //we reached at the position
            Node newNode=new Node(data);
            newNode.next=current;
            return newNode;
        }
        //index--;
        Node next=insertAtIndex(--index,data,current.next);
        current.next=next;
        return current;

    }
    //Node terminology
    public void insertAtPosition(int index,int data,Node current,Node previous)
    {
        // 11|->|12|->|13|->|20|->|14|->|15|->|16|->NULL

        if(index==0)
        {
            Node newNode=new Node(data);
            newNode.next=current;
            previous.next=newNode;
            return;

        }
        index--;
        insertAtPosition(index,data,current.next,current);
        return;

    }
    public Node createList()
    {
        int data=11;
        Node head=null;
        for(int i=0;i<8;i++)
        {

          head=addNode(data);
          data++;
        }
        return head;
    }

}