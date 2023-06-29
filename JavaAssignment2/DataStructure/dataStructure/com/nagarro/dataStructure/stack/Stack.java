package com.nagarro.dataStructure.stack;

import java.util.*;

public class Stack {
	private int arr[];
    private int top;
    private int capacity;
 

   
 
    public Stack(int size) {
    	arr = new int[size];
        capacity = size;
        top = -1;
}

    public void push(int x)
    {
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }
 
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }
 

    public int pop()
    {
     
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
 
        System.out.println("Removing " + peek());
 
        return arr[top--];
    }
 

    public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }
 
        return -1;
    }
 
 
    public int size() {
        return top + 1;
    }
    

 
    public boolean isEmpty() {
        return top == -1;               
    }
 
    public boolean isFull() {
        return top == capacity - 1;     
    }
    public void display()  
    {  
        System.out.println("Printing stack elements .....");  
        for(int i = top; i>=0;i--)  
        {  
            System.out.println(arr[i]);  
        }

}
    public int center() {
    	int startIndex = 0, lastIndex = top + 1;
    	return arr[startIndex + (lastIndex-startIndex)/2];
    }
    
    public void sort() {
    	int temp=0;
    	for (int i = 0; i <top+1; i++) {     
            for (int j = i+1; j <top+1; j++) {     
                if(arr[i] >arr[j]) {      //swap elements if not in order
                   temp = arr[i];    
                   arr[i] = arr[j];    
                   arr[j] = temp;    
                 }     
              }     
          }
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
        System.out.println(Arrays.toString(b));
}
  public  void iterator()
   {
	  
    	Iterator<Integer> I = Arrays.stream(arr).iterator();
    	while(I.hasNext())
    		System.out.println(I.next());
    
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
}
