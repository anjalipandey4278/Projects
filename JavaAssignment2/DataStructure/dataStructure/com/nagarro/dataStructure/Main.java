package com.nagarro.dataStructure;
import java.util.*;
import com.nagarro.dataStructure.stack.Stack;
import com.nagarro.dataStructure.queue.Queue;
import com.nagarro.dataStructure.linkedList.LinkedList;
import com.nagarro.dataStructure.priorityQueue.PriorityQueue;
import com.nagarro.dataStructure.exception.CustomException;
import com.nagarro.dataStructure.constant.Constants;
import com.nagarro.dataStructure.hashtable.DataItem;
import com.nagarro.dataStructure.hashtable.HashTable;
public class Main {

	public static void main(String[] args) {
		
   Stack stack=new Stack(10);
   Queue queue=new Queue(10);
   LinkedList list = new LinkedList();
    list.insert(18);
	list.insert(45);
	list.insert(12);
   PriorityQueue NewPriorityQueue= new PriorityQueue(10);
   HashTable hashtable = new HashTable(15);
   int ns;
   try {
   do {
   System.out.println("Enter your choice:");
   System.out.println("1. linkedlist");
   System.out.println("2. Stack");
   System.out.println("3. Queue");
   System.out.println("4. Priority Queue");
   System.out.println("5. HashTable");
   System.out.println("6. Exit");
   Scanner sc=new Scanner(System.in);
   ns=sc.nextInt();
   switch(ns) {
   case 1:{
	   
	   int ln;
	  
	   do {
		   
	   System.out.println("Enter your operations for linkedlist:");
	   System.out.println("1. insert");
	   System.out.println("2. Insert at position ");
	   System.out.println("3. Delete ");
	   System.out.println("4. Delete at position ");
	   System.out.println("5. Center ");
	   System.out.println("6. Sort ");
	   System.out.println("7. Iterator ");
	   System.out.println("8. Traverse/Print");
	   System.out.println("9. Reverse");
	   System.out.println("10. Size  ");
	   System.out.println("11. Exit  ");
	    ln=sc.nextInt();

	   switch(ln) {
	   case 1:
	   {
		   System.out.println("Enter value to insert");
		   int var1=sc.nextInt();
		   list.insert(var1);
		   System.out.println(" inserted successfully");
		   break;
		   
	   }
	   case 2:
	   {
		   System.out.println("Enter value to insert");
		   int val=sc.nextInt();
		   System.out.println("Enter position to insert");
		   int pos=sc.nextInt();
		   
		   list.insertAt(pos,val);
		   System.out.println(" inserted successfully at" + pos);
		   break;
		   
	   }
	   case 3:
	   {
		   System.out.println("Enter value to delete");
		   int val=sc.nextInt();
		   list.deleteNode(val);
		   System.out.println(" deleted successfully");
		   break;
		   
	   }
	   case 4:
	   {
		   System.out.println("Enter index to delete");
		   int pos=sc.nextInt();
		   list.deleteAt(pos);
		   System.out.println(" deleted successfully at" + pos);
		   break;
		   
	   }
	   case 5:{
		   list.center();
		   break;
	   }
	   case 6:{
		   list.sort();
		   System.out.println("Sorted");
		   break;
	   }
	   case 7:{
		   
	   }
	   case 8:{
		   list.display();
		   break;
	   }
	   case 9:{
		   list.PrintReversedList();
		   break;
	   }
	   case 10:{
		   
		   System.out.println(list.getCount());
		   break;
	   }
	   case 11:{
		   System.out.println(Constants.EXIT_PROGRAM);
		   System.exit(0);
		   break;
	        
	   }
	   default :
		   throw new CustomException("operation is not matched");
	   
	   }
	    
	/*	catch (CustomException e) {
			
			System.out.println("Exception occured" + " " + e);
		}
	   */
   }while(ns != 11 /*Exit loop when choice is 6*/);
	   break;
   }
   case 2:{
	   int st;
	   do {
	   System.out.println("Enter your operations for Stack:");
	   System.out.println("1. push");
	   System.out.println("2. pop ");
	   System.out.println("3. peek ");
	   System.out.println(Constants.CONTAINS);
	   System.out.println(Constants.SIZE);
	   System.out.println(Constants.CENTER);
	   System.out.println(Constants.SORT);
	   System.out.println(Constants.REVERSE);
	   System.out.println(Constants.ITERATOR);
	   System.out.println(Constants.TRAVERSE_PRINT);
	   System.out.println(Constants.EXIT);
	   st=sc.nextInt();
	   switch(st) {
	   case 1:{
		   System.out.println("Enter the value to push in Stack:");
		   int ps = sc.nextInt();
		   stack.push(ps);
		   System.out.println("value pushed"); 
		   break;
	   }
	   case 2:{
		   stack.pop();
		   System.out.println("value has been poped");
		   break;
		   
	   }
	   case 3:{
		   
		   System.out.println("The peek value is " + stack.peek());
		   break;
		   
		   
	   }
	   case 4:{
		   System.out.println("Enter the value to check in Stack:");
		   int ck = sc.nextInt();
		   stack.iscontains(ck);
		   break;
	   }
	   case 5:{
		   System.out.println("the size of stack is "+stack.size());
		   break;
	   }
	   case 6:{
		   System.out.println("The center value of stack is:" + stack.center());
		   break;
	   }
	   case 7:{
		   stack.sort();
		   System.out.println("Stack is sorted");
		   break;
	   }
	   case 8:{
		   stack.reverse();
		   System.out.println("Stack is reversed ");
		   break;
		   
	   }
	   case 9:{
		   stack.iterator();
		   break;
	   }
	   case 10:{
		   stack.display();
		   break;
	   }
	   case 11:{
		   System.out.println(Constants.EXIT_PROGRAM);
		   System.exit(0);
		   break;
	        
	   }
	   default :
		   throw new CustomException("operation is not matched");
	   }

	   }while(ns != 11 /*Exit loop when choice is 6*/);
	   break;  
   }
   case 3:{
	   int qu;
	   do {
	   System.out.println("Enter your operations for Queue:");
	   System.out.println(Constants.ENQUEUE);
	   System.out.println(Constants.DEQUEUE);
	   System.out.println(Constants.PEEK);
	   System.out.println(Constants.CONTAINS);
	   System.out.println(Constants.SIZE);
	   System.out.println(Constants.CENTER);
	   System.out.println(Constants.SORT);
	   System.out.println(Constants.REVERSE);
	   System.out.println(Constants.ITERATOR);
	   System.out.println(Constants.TRAVERSE_PRINT);
	   System.out.println(Constants.EXIT);
	   
	   qu=sc.nextInt();
	   switch(qu) {
	   case 1:{
		   System.out.println("Enter the value to Enqueue:");
		   int val = sc.nextInt();
		   queue.enqueue(val);
		   System.out.println("Value inserted in back of queue");
		   break;
		   
	   }
	   case 2:{
		   queue.dequeue();
		   System.out.println("the value has deleted from front");
		   break;
	   }
	   case 3:{
		   System.out.println("The peek value is"+queue.peek());
		   break;
	   }
	   case 4:{
		   System.out.println("Enter the value to check");
		   int val = sc.nextInt();
		   queue.iscontains(val);
		   break;
		   
	   }
	   case 5:{
		   System.out.println("The size is"+queue.size());
		   break;
	   }
	   
	   case 6:{
		   System.out.println("The center value is"+queue.center());
		   break;
	   }
	   case 7:{
		   queue.sort();
		   System.out.println("Queue is sorted");
		   break;
	   }
	   case 8:{
		   queue.reverse();
		   System.out.println("Queue is reversed");
		   break;
	   }
	   case 9:{
		   queue.iterator();
		   break;
	   }
	   case 10:{
		   queue.PrintQueue();
		   break;
	   }
	   case 11:{
		   System.out.println(Constants.EXIT_PROGRAM);
		   System.exit(0);
		   break;
	        
	   }
	   default:
		   throw new CustomException("operation is not matched");
	   }
	   }while(ns != 11 /*Exit loop when choice is 6*/);
	   break;
	   
	   
   }
   case 4:
   {
	   
	   int pqu;
	   do {
	   System.out.println("Enter your operations for PriorityQueue:");
	   System.out.println(Constants.ENQUEUE);
	   System.out.println(Constants.DEQUEUE);
	   System.out.println(Constants.PEEK);
	   System.out.println(Constants.CONTAINS);
	   System.out.println(Constants.SIZE);
	   System.out.println(Constants.CENTER);
	   System.out.println(Constants.SORT);
	   System.out.println(Constants.REVERSE);
	   System.out.println(Constants.ITERATOR);
	   System.out.println(Constants.TRAVERSE_PRINT);
	   System.out.println(Constants.EXIT);

	    pqu=sc.nextInt();
	   switch(pqu){
	   case 1:{
		   System.out.println("Enter the value to Enqueue:");
		   int val = sc.nextInt();
		   NewPriorityQueue.Enqueue(val);
		  
		   break;
		   
	   }
	   case 2:{
		   System.out.println("Enter the value to remove  from queue:");
		   int pq = sc.nextInt();
		   NewPriorityQueue.Dequeue(pq);
		   System.out.println("the value has deleted from front");
		   break;
	   }
	   case 3:{
		   NewPriorityQueue.Peek();
		   break;
	   }
	   case 4:{
		   System.out.println("Enter the value to check  in queue:");
		   int pq = sc.nextInt();
		   NewPriorityQueue.Contains(pq);
		   break;
	   }
	   case 5:{
		   NewPriorityQueue.SizeofPriorityQueue();
		   break;
	   }
	   case 6:{
		   System.out.println("the center value is"+NewPriorityQueue.center());
		   break;
	   }
	   case 7:{
		   NewPriorityQueue.sort();
		   System.out.println("sorted");
		   break;
		   
	   }
	   case 8:{
		   NewPriorityQueue.ReversePriorityQueue();
		   break;
	   }
	   case 9:{
		   NewPriorityQueue.iterator();
		   break;
	   }
	   case 10:{
		   NewPriorityQueue.PrintPriorityQueue();
		   break;
	   }
	   case 11:{
		   System.out.println(Constants.EXIT_PROGRAM);
		   System.exit(0);
		   break;
	        
	   }
	   default:
		   throw new CustomException("operation is not matched");
		   
	   }
	   }while(ns != 11 /*Exit loop when choice is 6*/);
	   break;
	   
   }
   case 5:{
	   int hs;
	   do {
	   System.out.println("Enter your operations for hashtable:");
	   System.out.println("1. Insert");
	   System.out.println("2. Delete ");
	   System.out.println("3. Contains ");
	   System.out.println("4. Get Value by key ");
	   System.out.println("5. Size ");
	   System.out.println("6. Iterator ");
	   System.out.println("7. Traverse/Print ");
	   System.out.println("8. Exit  ");
	   hs=sc.nextInt();
	   switch(hs) {
	   case 1:{
		   System.out.println("Enter key for hashtable:");
		   int s = sc.nextInt();
		   System.out.println("Enter value for hashtable:");
		   int v =sc.nextInt();
		   DataItem data = new DataItem(s,v);
		   hashtable.insert(data);
		   System.out.println("Inserted in hashtable:");
		   break;
	   }
	   case 2:{
		   System.out.println("Enter key for hashtable:");
		   int s = sc.nextInt();
		   System.out.println("Enter value for hashtable:");
		   int v =sc.nextInt();
		   DataItem data = new DataItem(s,v);
		   hashtable.delete(data);
		   System.out.println("deleted in hashtable:");
		   break;
	   }
	   case 3:{
		   System.out.println("Enter to check in hashtable:");
		   int s = sc.nextInt();
		   hashtable.isContains(s);
		   break;
	   }
	   case 4:{
		   System.out.println("Enter to find by key in hashtable:");
		   int s = sc.nextInt();
		    hashtable.search(s);
		   
		   break;
	   }
	   case 5:{
		   System.out.println("the size of hashtable"+hashtable.size());
		   break;
	   }
	   case 6:{
		   break;
	   }
	   case 7:{
		   hashtable.display();
		   break;
	   }
	   case 8:{
		   System.out.println(Constants.EXIT_PROGRAM);
		   System.exit(0);
		   break;
	        
	   }
	   default:
		   throw new CustomException("operation is not matched");
		   
	   }
	   }while(ns != 8 /*Exit loop when choice is 6*/);
	   break;
	  
  
   
   }
   case 6:{
	   System.out.println(Constants.EXIT_PROGRAM);
       System.exit(0);
        break;
   }
   default:
	   throw new CustomException("operation is not matched");
	   
   }
	}while(ns != 6 /*Exit loop when choice is 6*/);
   
   }
	catch (CustomException e) {
		
		System.out.println("Exception occured" + " " + e);
	}
	}
}


	


