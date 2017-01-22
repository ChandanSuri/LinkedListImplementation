/**
 * Created by Chandan Suri on 1/21/2017.
 */
import java.util.Scanner;
/*
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

public class SinglyLinkedList {

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
            }
            if(flag_to_exit == 1)
                break;
        }
        System.out.print("Exiting.........\n");
    }
}

*/



















