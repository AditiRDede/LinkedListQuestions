package PatternQuestions;

public class CycleDetection
{
    public static void main(String [] args)
    {
        System.out.println("Cycle detection in linkedList");
        LinkedListDemo obj=new LinkedListDemo();
        CycleDetection c=new CycleDetection();
        LinkedListDemo.Node list=obj.createList();
        obj.displayList();
        //maintain tail
        LinkedListDemo.Node tail=c.getTail(obj.head);
        c.cyclecreation(list);

        System.out.println("Cycle exist : "+c.detectCycle(obj.head));
        c.displayCycle(obj.head,tail);


    }
    public void cyclecreation(LinkedListDemo.Node list)
    {
        //create cycle at index 3 from last node
        int index=3;
        LinkedListDemo.Node temp=list;
        LinkedListDemo.Node target=null;
        while (temp.next!=null)
        {
            if(index==0)
            {
                target=temp;
                index=-1;
            }
            else
            {
                index--;
            }
            temp=temp.next;
        }
        //crearte cycle from last node to target node
        System.out.println("target node : "+target.data);
        temp.next=target;


    }
    public boolean detectCycle(LinkedListDemo.Node head) {
        LinkedListDemo.Node fast = head;
        LinkedListDemo.Node slow = head;

        while (fast != null && fast.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                return true;
            }
        }
        return false;
    }
    public void displayCycle(LinkedListDemo.Node head,LinkedListDemo.Node tail)
    {

        LinkedListDemo.Node temp=head;
        while (temp!=tail)
        {
            System.out.print("|"+temp.data+"|-->");
            temp=temp.next;
        }
        System.out.print("|"+temp.data+"|-->");
        System.out.println("|cyclestartnode-->|"+temp.next.data+"|");


    }
    public LinkedListDemo.Node getTail(LinkedListDemo.Node head)
    {
        LinkedListDemo.Node temp=head;
        while (temp.next!=null)
        {

            temp=temp.next;
        }
        System.out.println("Last node : "+temp.data);
        return temp;
    }
}
