/**
 * Created by Chandan Suri on 1/21/2017.
 */
import java.util.Scanner;

class Node {

    protected int data;
    protected Node next;

    public Node()
    {
        next = null;
        data = 0;
    }

    public Node(int d, Node n)
    {
        next = n;
        data = d;
    }

    public void setNext(Node n)
    {
        next = n;
    }

    public void setData(int d)
    {
        data = d;
    }

    public Node getNext()
    {
        return next;
    }

    public int getData()
    {
        return data;
    }

}

class linkedList
{
    protected Node start;
    protected Node end;
    public int size;

    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return start == null;
    }

    public int getSize()
    {
        return size;
    }

    public void insertAtStart(int val)
    {
        Node i_node = new Node(val, null);
        size++;
        if(start == null){
            start = i_node;
            end = start;
        }else {
            i_node.setNext(start);
            start = i_node;
        }
    }

    public void insertAtEnd(int val)
    {
        Node i_node = new Node(val, null);
        size++;
        if(start==null){
            start = i_node;
            end = start;
        }else{
            end.setNext(i_node);
            end = i_node;
        }
    }

    public void insertAtPos(int val, int pos)
    {
        Node i_node = new Node(val, null);
        pos--;
        Node ptr = start;

        while(pos!=1)
        {
            ptr = ptr.getNext();
            pos--;
        }

        Node tmp = ptr.getNext();
        ptr.setNext(i_node);
        i_node.setNext(tmp);
        size++;
    }

    public void deleteAtPos(int pos)
    {
        if(pos == 1)
        {
            start = start.getNext();
            size--;
            return;
        }
        if(pos == size)
        {
            Node ptr = start;
            while(ptr.getNext() != end)
            {
                ptr = ptr.getNext();
            }
            end = ptr;
            end.setNext(null);
            size--;
            return;
        }
        Node ptr = start;
        pos = pos - 1;
        while(pos!=1)
        {
            ptr = ptr.getNext();
        }
        Node tmp = ptr.getNext().getNext();
        ptr.setNext(tmp);
        size--;
    }

    public void rotateLeft(int k)
    {
        if(k<=0)
            return;
        Node prev = null;
        Node list2 = start;
        while(k!=0)
        {
            k--;
            prev = list2;
            list2 = list2.getNext();
        }
        while(list2.getNext()!=null)
        {
            list2 = list2.getNext();
        }
        list2.setNext(start);
        start = prev.getNext();
        prev.setNext(null);

    }

    public void sumList(Node l1, Node l2)
    {
        int carry = 0;
        while((l1!=null) || (l2!=null) || carry == 1)
        {
            size++;
            int s = carry;
            if(l1!=null)
            {
                s += l1.getData();
                l1 = l1.getNext();
            }
            if(l2!=null)
            {
                s += l2.getData();
                l2 = l2.getNext();
            }
            Node tmp = new Node(s%10, null);
            if(start == null)
            {
                start = tmp;
                end = start;
            }else{
                end.setNext(tmp);
                end = end.getNext();
            }
            if(s>9)
                carry = 1;
            else
                carry = 0;

        }
    }

    public Node findKth(int k)
    {
        Node slow_ptr = start;
        Node fast_ptr = start;
        while(k!=0)
        {
            fast_ptr = fast_ptr.getNext();
            k -= 1;
        }
        while(fast_ptr!=null)
        {
            slow_ptr = slow_ptr.getNext();
            fast_ptr = fast_ptr.getNext();
        }
        return slow_ptr;
    }

    public boolean detectCycle()
    {
        boolean cycle_found = false;
        Node slow_ptr = start;
        Node fast_ptr = start;
        while(slow_ptr!=null && fast_ptr!=null && fast_ptr.getNext()!=null)
        {
            slow_ptr = slow_ptr.getNext();
            fast_ptr = fast_ptr.getNext().getNext();
            if(slow_ptr == fast_ptr)
            {
                cycle_found = true;
                break;
            }
        }
        return cycle_found;
    }

    public void findCycleBeg()
    {
        Node slow_ptr = start;
        Node fast_ptr = start;
        while(slow_ptr!=fast_ptr){
            slow_ptr = slow_ptr.getNext();
            fast_ptr = fast_ptr.getNext().getNext();
        }
        fast_ptr = start;
        while(slow_ptr!=fast_ptr){
            slow_ptr = slow_ptr.getNext();
            fast_ptr = fast_ptr.getNext();
        }
        System.out.println("The Cycle Beginning is => "+slow_ptr.getData());
    }

    public Node mergeSort(Node head_node)
    {
        Node head = head_node;
        Node l1 = head;
        Node l2 = head.getNext();

        if(head == null || head.getNext()==null)
            return head;

        while((l2!=null) && (l2.getNext()!=null))
        {
            head = head.getNext();
            l2 = l2.getNext().getNext();
        }
        l2 = head.getNext();
        head.setNext(null);
        return merge(mergeSort(l1), mergeSort(l2));
    }

    public Node merge(Node l1, Node l2)
    {
        Node tmp = new Node();
        Node head = tmp;
        Node l3 = head;

        while((l1!=null) && (l2!=null))
        {
            if(l1.getData()<= l2.getData()){
                l3.setNext(l1);
                l3 = l1;
                l1 = l1.getNext();
            }else{
                l3.setNext(l2);
                l3 = l2;
                l2 = l2.getNext();
            }
        }

        l3.setNext((l1==null)?l2:l1);
        return head.getNext();
    }

    public void reverse(Node curr, Node prev)
    {
        if(curr.getNext()==null)
        {
            start = curr;
            curr.setNext(prev);
            return;
        }
        if(prev==null)
        {
            end = curr;
        }
        Node next_ptr = curr.getNext();
        curr.setNext(prev);
        reverse(next_ptr, curr);
    }

    public void display()
    {
        if(size == 0)
        {
            System.out.println("This Linked List has no elements in it");
            return;
        }
        if (start.getNext()==null)
        {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        while(ptr.getNext()!=null)
        {
            System.out.print(ptr.getData()+"->");
            ptr = ptr.getNext();
        }
        System.out.println(ptr.getData());
        System.out.print("The List has been printed out\n");
    }
}

public class OperationsLinkedList{

    public static void main(String[] args)
    {
        Scanner d = new Scanner(System.in);
        linkedList newList = new linkedList();

        System.out.println("Singly Linked List=>\n");
        int choice;

        while(true)
        {
            System.out.println("Please Enter a choice=> \n" +
                    "1. Insert element at the beginning.\n" +
                    "2. Insert element at the end.\n" +
                    "3. Insert element at a specific position.\n" +
                    "4. Delete element at a specific position.\n" +
                    "5. Check if the linked list is empty.\n" +
                    "6. See the size of the linked List and the List itself.\n" +
                    "7. Rotate the list Left.\n" +
                    "8. Calculate sum of 2 lists digit wise.\n" +
                    "9. Find Kth Node from End.\n" +
                    "10. Detect a cycle in a List Entered.\n" +
                    "11. Find the starting point of the cycle if present in the Linked List.\n" +
                    "12. Merge 2 sorted Linked Lists.\n" +
                    "13. Perform Merge Sort on linked List.\n" +
                    "14. Reverse a Linked List.\n" +
                    "Please Enter 0 for exiting from the program....\n");

            choice = d.nextInt();
            int flag_to_exit = 0;
            switch (choice)
            {
                case 0:
                    flag_to_exit = 1;
                    break;
                case 1:
                    System.out.println("Please Enter the number to insert => ");
                    newList.insertAtStart(d.nextInt());
                    newList.display();
                    break;
                case 2:
                    System.out.print("Please Enter the number to insert => ");
                    newList.insertAtEnd(d.nextInt());
                    newList.display();
                    break;
                case 3:
                    System.out.print("Please Enter the number to insert => ");
                    int num = d.nextInt();
                    System.out.print("Please Enter the position => ");
                    int pos = d.nextInt();
                    if (pos<=1 || pos>newList.getSize())
                        System.out.println("Invalid Position\n");
                    else
                        newList.insertAtPos(num, pos);
                    newList.display();
                    break;
                case 4:
                    System.out.print("Please Enter the position => ");
                    int pos_d = d.nextInt();
                    if(pos_d < 1 || pos_d >newList.getSize())
                        System.out.print("Invalid Position\n");
                    else
                        newList.deleteAtPos(pos_d);
                    newList.display();
                    break;
                case 5:
                    boolean emp = newList.isEmpty();
                    if (emp)
                        System.out.println("The List is empty.");
                    else
                        System.out.println("The List is not empty.");
                    break;
                case 6:
                    System.out.print("The Size of the List is => "+newList.getSize()+"\n");
                    newList.display();
                    break;
                case 7:
                    System.out.print("Please enter the position where to rotate about => ");
                    int r_pos = d.nextInt();
                    System.out.print("The reversed List is => ");
                    newList.rotateLeft(r_pos);
                    newList.display();
                case 8:
                    System.out.println("Entering the 2 lists => ");
                    linkedList list1 = new linkedList();
                    linkedList list2 = new linkedList();
                    System.out.println("Enter the lengths/sizes of the 2 lists => ");
                    System.out.print("1st => ");
                    int size1 = d.nextInt();
                    System.out.print("2nd => ");
                    int size2 = d.nextInt();

                    System.out.print("First List Entries => ");
                    for(int i=1;i<=size1;i++)
                    {
                        if(i==1)
                            list1.insertAtStart(d.nextInt());
                        else
                            list1.insertAtPos(d.nextInt(), i);
                    }

                    System.out.print("Second List Entries => ");
                    for(int i=1;i<=size2;i++)
                    {
                        if(i==1)
                            list2.insertAtStart(d.nextInt());
                        else
                            list2.insertAtPos(d.nextInt(), i);
                    }
                    linkedList final_list = new linkedList();
                    final_list.sumList(list1.start, list2.start);
                    System.out.print("The Final List formed is => ");
                    final_list.display();
                    break;
                case 9:
                    System.out.print("Enter the value of K => ");
                    int k = d.nextInt();
                    if(k>newList.getSize() || k<1)
                        System.out.print("Invalid Position Entered.\n");
                    else {
                        Node kNode = newList.findKth(k);
                        System.out.print("The value is => " + kNode.getData());
                    }
                    break;
                case 10:
                    linkedList cycle_list = new linkedList();
                    boolean first = true;
                    while(true)
                    {
                        System.out.println("Enter element to be entered => (Enter -999 to exit input.)");
                        int data = d.nextInt();
                        if(data==-999)
                            break;
                        else{
                            if(first)
                                cycle_list.insertAtStart(data);
                            else
                                cycle_list.insertAtEnd(data);
                        }
                    }
                    boolean cycle_found = cycle_list.detectCycle();
                    if(cycle_found)
                        System.out.print("The Cycle was Found!!");
                    else
                        System.out.print("Sorry, There's no cycle in the List!!");
                    break;
                case 11:
                    linkedList c_list = new linkedList();
                    boolean first_ele = true;
                    while(true)
                    {
                        System.out.print("Enter element to be entered => (Enter -999 to exit input.)");
                        int data = d.nextInt();
                        if(data==-999)
                            break;
                        else{
                            if(first_ele)
                                c_list.insertAtStart(data);
                            else
                                c_list.insertAtEnd(data);
                        }
                    }
                    boolean c_found = c_list.detectCycle();
                    if(c_found)
                        c_list.findCycleBeg();
                    else
                        System.out.print("Sorry, There's no cycle in the List!!");
                    break;
                case 12:
                    System.out.println("Entering the 2 lists => ");
                    linkedList list_1 = new linkedList();
                    linkedList list_2 = new linkedList();
                    System.out.println("Enter the lengths/sizes of the 2 lists => ");
                    System.out.print("1st => ");
                    int size_1 = d.nextInt();
                    System.out.print("2nd => ");
                    int size_2 = d.nextInt();

                    System.out.print("First List Entries => ");
                    for(int i=1;i<=size_1;i++)
                    {
                        if(i==1)
                            list_1.insertAtStart(d.nextInt());
                        else
                            list_1.insertAtPos(d.nextInt(), i);
                    }

                    System.out.print("Second List Entries => ");
                    for(int i=1;i<=size_2;i++)
                    {
                        if(i==1)
                            list_2.insertAtStart(d.nextInt());
                        else
                            list_2.insertAtPos(d.nextInt(), i);
                    }
                    linkedList fin_list = new linkedList();
                    fin_list.start = fin_list.merge(list_1.start, list_2.start);
                    System.out.print("The Final List formed is => ");
                    fin_list.display();
                    break;
                case 13:
                    newList.start = newList.mergeSort(newList.start);
                    System.out.print("The Sorted List is => ");
                    newList.display();
                    break;
                case 14:
                    System.out.print("Reversing a Linked List....\n");
                    newList.reverse(newList.start, null);
                    System.out.print("The Reversed List is => ");
                    newList.display();
                    break;
            }
            if(flag_to_exit == 1)
                break;
        }
        System.out.print("Exiting.........\n");
    }
}





















