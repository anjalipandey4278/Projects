package com.nagarro.dataStructure.priorityQueue;
import java.util.*;
public class PriorityQueue
{
    private int[] PriorityQueueImplementation;
    private int front;
    private int rear;
    private int max;
    private int PriorityQueueSize;

    public PriorityQueue(int size)
    {
        PriorityQueueImplementation = new int[size];
        front = -1;
        rear = -1;
        max = size;
    }
    
    //ENQUEUE
    public void Enqueue(int Data)
    {
        try
        {
            if (rear >= max - 1)
            {
                System.out.println("can not insert queue is full!");
                return;
            }
            else if ((front == -1) && (rear == -1))
            {
            	System.out.println("inserted");
                front++;
                rear++;
                PriorityQueueImplementation[rear] = Data;
                PriorityQueueSize += 1;
                
                return;
            }
            else
                CheckPriority(Data);

            rear++;
        }
        catch(Exception e)
        {
            throw e;
        }

    }

    //FIND PRIORITY 
    public void CheckPriority(int Data)
    {
        try
        {
            int i, j;
            PriorityQueueSize += 1;
            System.out.println("The Element inserted");
            for (i = 0; i <= rear; i++)
            {
                if (Data >= PriorityQueueImplementation[i])
                {
                    for (j = rear + 1; j > i; j--)
                    {
                        PriorityQueueImplementation[j] = PriorityQueueImplementation[j - 1];
                    }
                    PriorityQueueImplementation[i] = Data;
                    return;
                }
            }

            PriorityQueueImplementation[i] = Data;
        }
        catch(Exception e)
        {
            throw e;
        }
       
    }

    //DEQUEUE
    public void Dequeue(int Data)
    {
        try
        {
            int i;

            if ((front == -1) && (rear == -1))
            {
            	System.out.println("Queue is Empty can not delete");
                return;
            }
            else
            {
                for (i = 0; i <= rear; i++)
                {
                    if (Data == PriorityQueueImplementation[i])
                    {
                    	System.out.println("Element deleted");
                        PriorityQueueSize -= 1;
                        for (; i < rear; i++)
                        {
                            PriorityQueueImplementation[i] = PriorityQueueImplementation[i + 1];
                        }

                        PriorityQueueImplementation[i] = -99;
                        rear--;


                        if (rear == -1)
                            front = -1;
                        return;
                    }
                }


            }
            System.out.println("data not found to delete");
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    //PRINT PRIORITY QUEUE
    public void PrintPriorityQueue()
    {
        try
        {
            if ((front == -1) && (rear == -1))
            {
            	System.out.println("Queue is empty");
                return;
            }

            for (; front <= rear; front++)
            {
            	System.out.println( PriorityQueueImplementation[front]);
            }

            front = 0;

        }
        catch(Exception e)
        {
            throw e;
        }
    }
    public int center() {
    	int startIndex = 0, lastIndex = rear + 1;
    	return PriorityQueueImplementation[startIndex + (lastIndex-startIndex)/2];
    }

    //CONTAINS
    public void Contains(int Data)
    {
        try
        {
            boolean FoundElement = false;
            if ((front == -1) && (rear == -1))
            {
            	System.out.println("Queue is Already empty");
                return;
            }
            else
            {
                for (; front <= rear; front++)
                {
                    if (Data == PriorityQueueImplementation[front])
                    {
                    	System.out.println("Found");
                        FoundElement = true;
                    }
                }
                if (!FoundElement)
                {
                	System.out.println("not found in the Queue");
                }
            }
            front = 0;
        }
        catch (Exception e)
        {
            throw e;
        }

    }
    public void sort() {
    	int []arr = PriorityQueueImplementation.clone();
    	int temp=0;
    	for (int i = 0; i <arr.length; i++) {     
            for (int j = i+1; j <arr.length; j++) {     
                if(arr[i] >arr[j]) {      //swap elements if not in order
                   temp = arr[i];    
                   arr[i] = arr[j];    
                   arr[j] = temp;    
                 }     
              }     
          }
    }
    
    //REVERSE PRIORITY QUEUE
    public void ReversePriorityQueue()
    {
        try
        {
        	int []arr = PriorityQueueImplementation;
        	int n=rear+1;
        	int[] b = new int[n];
            int j = n;
            for (int i = 0; i < n; i++) {
                b[j - 1] = arr[i];
                j = j - 1;
        	
        }
            System.out.println(Arrays.toString(b));
        }
        
        catch(Exception e)
        {
            throw e;
        }
    }

    //PEEK
    public void Peek()
    {
        try
        {
        	System.out.println("The Element with the Highest priority is" + PriorityQueueImplementation[front]);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    public  void iterator()
    {
 	  
     	Iterator<Integer> I = Arrays.stream(PriorityQueueImplementation).iterator();
     	while(I.hasNext())
     		System.out.println(I.next());
     
     }

    //SIZE OF PRIORITY QUEUE
    public void SizeofPriorityQueue() 
    {
        try
        {
        	System.out.println("The Size of Priority Queue is" + PriorityQueueSize);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}