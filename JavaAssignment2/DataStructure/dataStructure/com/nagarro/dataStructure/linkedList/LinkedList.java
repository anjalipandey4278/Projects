package com.nagarro.dataStructure.linkedList;

import java.util.Arrays;
import com.nagarro.dataStructure.iterator.Iterator;


public class LinkedList 
{
	public Node head;
	int [] arr;
	
	public void insert(int data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(head==null)
		{
			head = node;
		}
		else
		{
			Node n = head;
			while(n.next!=null)
			{
				n = n.next;
			}
			n.next =  node;
		}
		
	}
	public void insertAtStart(int data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.next = head;
		head = node;
	}
	
	public void insertAt(int index,int data)
	{
	    Node node = new Node();
	    node.data = data;
	    node.next = null;

	    if (this.head == null) {
	      //if head is null and position is zero then exit.
	      if (index != 0) {
	       return;
	      } else { //node set to the head.
	       this.head = node;
	      }
	    }

	    if (head != null && index == 0) {
	      node.next = this.head;
	      this.head = node;
	      return;
	    }

	    Node current = this.head;
	    Node previous = null;

	    int i = 0;

	    while (i < index) {
	      previous = current;
	      current = current.next;

	      if (current == null) {
	        break;
	      }

	       i++;
	      }

	      node.next = current;
	      previous.next = node;
	}
	
	public void deleteNode(int key)
    {
        // Store head node
        Node temp = head, prev = null;
 
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }
 
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
 
        // If key was not present in linked list
        if (temp == null)
            return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
    }

	public void deleteAt(int index)
	{
		if(index==0)
		{
			head = head.next;
		}
		else
		{
			Node n = head;
			Node n1 = null;
			for(int i=0;i<index-1;i++)
			{
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			//System.out.println("n1 " + n1.data);
			n1 = null;
		}
	}

	public Node reverse(Node Head)
    {
        Node CurrentNode = head;
        Node PreviousNode = null;
        Node TempNext;
        while (CurrentNode != null)
        {
            TempNext = CurrentNode.next;
            CurrentNode.next = PreviousNode;
            PreviousNode = CurrentNode;
            CurrentNode = TempNext;
        }
        //PreviousNode = CurrentNode;
        return PreviousNode;
    }
	 public void PrintReversedList()
     {
         try
         {
             Node CurrentNode = reverse(head);
             System.out.println("The Reversed Linked List is: ");
             while (CurrentNode != null)
             {
            	 System.out.println(CurrentNode.data + "  ");
                 CurrentNode = CurrentNode.next;
             }
             
         }
         catch(Exception e)
         {
             throw e;
         }

     }
	
   public void center()
   {
	   try {
		
       if (head != null) {
           int length = getCount();
           Node temp = head;
           int middleLength = length / 2;
           while (middleLength != 0) {
               temp = temp.next;
               middleLength--;
           }
           System.out.print("The middle element is ["
                            + temp.data + "]");
           System.out.println();
       }
	   }
       catch(Exception e)
       {
           throw e;
       }
   }
   public void sort()
   {
       // Node current will point to head
       Node current = head, index = null;
 
       int temp;
 
       if (head == null) {
           return;
       }
       else {
           while (current != null) {
               // Node index will point to node next to
               // current
               index = current.next;
 
               while (index != null) {
            	   if (current.data > index.data) {
                       temp = current.data;
                       current.data = index.data;
                       index.data = temp;
                   }
 
                   index = index.next;
               }
               current = current.next;
           }
       }
   }
               

   public int size(Node node,int count)
   {
       if (node == null)
           return count;
 
       // Move to the next node and increase count
       return size(node.next,1+count);
   }
 
   /* Wrapper over getCountRec() */
   public int getCount()
   {
       return size(head,0);
   }

   public Iterator iterator() {
       return new Iterator() {
           Node temp = head;



          @Override
           public int next() {
               int t = temp.data;
               temp = temp.next;
               return t; // naming



          }



          @Override
           public boolean hasnext() {
               if (head == null) {
                   System.out.println("Emtpty");
               }



              return temp != null;
           }
       };
   }
	
	public void display()
	{
		Node node = head;
	
		while(node.next!=null)
		{
			System.out.println(node.data);
			node = node.next;
			
		}
		System.out.println(node.data);
	}
}