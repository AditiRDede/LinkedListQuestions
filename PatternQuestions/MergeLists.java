package PatternQuestions;

public class MergeLists
{


    public static void main(String [] args)
    {
        System.out.println("Merge two sorted lists");
        LinkedListDemo ll1=new LinkedListDemo();
        ll1.addNode(11);
        ll1.addNode(12);
        ll1.addNode(17);
        ll1.addNode(35);
        ll1.addNode(38);
        LinkedListDemo ll2=new LinkedListDemo();
        ll2.addNode(3);
        ll2.addNode(4);
        ll2.addNode(5);
        ll2.addNode(19);
        ll2.addNode(23);

        ll1.displayList();
        ll2.displayList();

        LinkedListDemo.Node list1=ll1.head;
        LinkedListDemo.Node list2=ll2.head;

        //
        MergeLists obj=new MergeLists();
        LinkedListDemo anslist=obj.mergeSortedList(list1,list2);
        anslist.displayList();


    }
    public LinkedListDemo mergeSortedList(LinkedListDemo.Node list1,LinkedListDemo.Node list2)
    {
        LinkedListDemo.Node first=list1;
        LinkedListDemo.Node second=list2;
        LinkedListDemo anslist=new LinkedListDemo();


        while (first!=null && second!=null)
        {
            if(first.data<second.data)
            {
                anslist.addNode(first.data);
                first=first.next;


            }
            else
            {
                anslist.addNode(second.data);
                second=second.next;
            }
        }
        while (first!=null)
        {
            anslist.addNode(first.data);
            first=first.next;
        }
        while (second!=null)
        {
            anslist.addNode(second.data);
            second=second.next;
        }



        return anslist;
    }
}
