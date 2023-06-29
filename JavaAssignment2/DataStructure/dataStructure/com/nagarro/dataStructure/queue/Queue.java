package com.nagarro.dataStructure.queue;

import java.util.*;
import java.util.Iterator;

public class Queue {
	private int[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue
 
    // Constructor to initialize a queue
    public Queue(int size)
    {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }
 
    //  dequeue the front element
    public int dequeue()
    {
        // check for queue underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
 
        int x = arr[front];
        

        System.out.println("Removing " + x);
        
 
        front = (front + 1) % capacity;
        count--;
 
        return x;
    }
 
    //  add an item to the queue
    public void enqueue(int item)
    {
        // check for queue overflow
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(-1);
        }
 
        System.out.println("Inserting " + item);
 
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
 
    // return the front element of the queue
    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return arr[front];
    }
 
    // return the size of the queue
    public int size() {
        return count;
    }
 
    //  check if the queue is empty or not
    public boolean isEmpty() {
        return (size() == 0);
    }
 
    //  check if the queue is full or not
    public boolean isFull() {
        return (size() == capacity);
    }
    public int center() {
    	int startIndex = 0, lastIndex = rear - 1;
    	return arr[startIndex + (lastIndex-startIndex)/2];
    }
    
    public void sort() {
    	int temp=0;
    	for (int i = 0; i <rear+1; i++) {     
            for (int j = i+1; j <rear+1; j++) {     
                if(arr[i] >arr[j]) {      //swap elements if not in order
                   temp = arr[i];    
                   arr[i] = arr[j];    
                   arr[j] = temp;    
                 }     
              }     
          }
    }
    public void PrintQueue()
    {
        try
        {
            if (front == rear + 1)
            {
                System.out.println("Queue is Already Empty");
                return;
            }
            else
            {
                for (int i = front; i <= rear; i++)
                {
                	System.out.println( arr[i]);
                }
            }

        }
        catch(Exception e)
        {
            throw e;
        }
    }
    public void display()  
    {  
        System.out.println("Printing stack elements .....");  
        for(int i = rear; i>=0;i--)  
        {  
            System.out.println(arr[i]);  
        }

}
    public void iscontains(int toCheckValue ) {
    	boolean test=false;
    	for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                System.out.println(test);
                break;
            }
    	
    }
    	
    	

}
    public  void iterator()
    {
 	  
    	Iterator<Integer> I = Arrays.stream(arr).iterator();
     	while(I.hasNext())
     		System.out.println(I.next());
     
     }      

    public void reverse()
    {
        int n=size();
        int[] b=new int[n];
        int j=n;
       
        for (int i = 0; i < n; i++) {
            b[j - 1] = arr[i];
            j = j - 1;
        }
        System.out.print(Arrays.toString(b));
}
}