package com.nagarro.dataStructure.hashtable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class HashTable {
	private DataItem[] hashArray;    
	   private int size;
	   private DataItem items;

	   public HashTable(int size){
	      this.size = size;
	      hashArray = new DataItem[size];
	      items = new DataItem(-1,-1);
	   }

	   public int getIndex(int key){
	      return key % size;
	   }

	   public DataItem search(int key){               
	      //get the hash 
	      int hashIndex = getIndex(key);        
	      //move in array until an empty 
	      while(hashArray[hashIndex] !=null){
	         if(hashArray[hashIndex].getKey() == key)
	            System.out.println(hashArray[hashIndex].getData()); 
	         //go to next cell
	         ++hashIndex;
	         hashIndex %= size;
	      }        
	      return null;        
	   }
	  
	   public void insert(DataItem item){
	      int key = item.getKey();
	      //get the hash 
	      int hashIndex = getIndex(key);
	      while(hashArray[hashIndex] !=null
	         && hashArray[hashIndex].getKey() != -1){
	         ++hashIndex;
	         //wrap around the table
	         hashIndex %= size;
	      }

	      hashArray[hashIndex] = item;        
	   }

	   public void display(){
		      for(int i=0; i<size; i++) {
		         if(hashArray[i] != null)
		            System.out.print(" ("
		               +hashArray[i].getKey()+","
		               +hashArray[i].getData() + ") ");
		         else
		            System.out.print(" ~~ ");
		      }
		      System.out.println("");
		   }
	   public void isContains(int toCheckValue) {
		   if(search(toCheckValue)!=null) {
			System.out.println("value is present");   
		   }
		   else {
			   System.out.println("value is not present");
			   
		   }
		   
	   }
	   public void iterator() {
		   
		   Iterator I = Arrays.stream(hashArray).iterator();
	    	while(I.hasNext())
	    		System.out.println(I.next());
	   }
	   public DataItem delete(DataItem item){
	      int key = item.getKey();
	      //get the hash 
	      int hashIndex = getIndex(key);
	      //move in array until empty 
	      while(hashArray[hashIndex] !=null){
	         if(hashArray[hashIndex].getKey() == key){
	            DataItem temp = hashArray[hashIndex]; 
	            hashArray[hashIndex] = items; 
	            return temp;
	         }                  
	         //go to next cell
	         ++hashIndex;
	         hashIndex %= size;
	      }        
	      return null;        
	   }
	   public int size(){
		    
		   return  hashArray.length;
		   
	   }

}
