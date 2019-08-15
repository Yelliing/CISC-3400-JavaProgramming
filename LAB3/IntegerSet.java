//package projects.intset;
// Exercise 8.13 IntegerSet.java
// IntegerSet class definition
import java.util.Scanner;
import java.util.Arrays; 

public class IntegerSet {
   private final int MAXSETSIZE = 101;
   // TODO: add the instance variables
    int[] intArray = new int[MAXSETSIZE];
    int size = 0;
    public static final Scanner input = new Scanner(System.in);
   
   // TODO: Implement no-argument (default) constructor, creates an empty set
    public IntegerSet(){
        this.intArray[0] = 0;
        this.size = 0;
    }
   
   // TODO: Implement constructor that creates a set from an array of integers
    public IntegerSet(int[] array){
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > 0 && array[i] < 101){
                this.intArray[index] = array[i];
                ++index;
            }
        }
        this.size = index;
        this.sortSet();
    }
   
   // TODO: Implement toString() that returns a string representation of set 
    public String toString(){
       if (this.intArray[0] == 0)
           return String.format("{ - }%n");
       else{
           String output = String.format("{ %d ", this.intArray[0]);
           for (int i = 1; i < this.size; i++){
                output += String.format("%d ", this.intArray[i]); 
           }
           output += "}";
           return String.format("%s%n", output);
       }
       
   }
   
   // TODO: Implement union that returns a new IntegerSet containing the union of two sets
   public IntegerSet unionSet(IntegerSet set1, IntegerSet set2){
       int i = 0;
       int index = 0;
       for (i = 0; i < set1.size; i++){
           this.intArray[i] = set1.intArray[i];
       }
       //place the second array in the back
       for (int j = 0;j < set2.size; j++){
           ++i;
           this.intArray[i] = set2.intArray[j];
       }
       this.size = i;
       
       //sort the array, avoid replication
       
       this.sortSet();
       
       return this;
   }

   
   // TODO: Implement intersection that returns a new IntegerSet containing the intersection of two sets
    public IntegerSet intersectionSet(IntegerSet set1, IntegerSet set2){
       int k = 0;
       for (int i = 0; i < set1.size; i++){
             for (int j = 0; j < set2.size; j++){
                if (set1.intArray[i] == set2.intArray[j]){
                    this.intArray[k] = set1.intArray[i];
                    ++k;
                }
            }
       }
       
       // intersection does not need to sort 
       this.size = k;
       return this;
   }

   // TODO: Implement a mutator to insert a new integer into this set. 
    public void insertValue(int value){
        if (value > 0 && value < 101){
            if (value > this.intArray[size-1]){
                this.intArray[size] = value;
                ++this.size;
            }
            for (int i = 0; i < this.size; i++){
                if (value < this.intArray[i]){
                    for (int j = this.size; j > i; j--){
                        this.intArray[j] = this.intArray[j-1];
                    }
                    this.intArray[i] = value;
                    break;
                }
            }

            ++this.size;
        }

    }
   
   // TODO: Implement a mutator to remove an integer from this set
    public void deleteValue(int value){
        for (int i = 0; i < this.size; i++){
            if (value == this.intArray[i]){
                for (int j = i; j < this.size; j++){
                    this.intArray[j] = this.intArray[j+1];
                }
                // this.intArray[size]=0;
                --this.size;
                break;
            }
        }
    }

   // TODO: Implement an equals method to determine if two sets are equal
    public boolean equalSet(IntegerSet set1){
        if (Arrays.equals(this.intArray, set1.intArray)){
            return true;
        }
        else{
            return false;
        }
        
    }

   // I did not use this method
   // TODO: Implement a validEntry method determine if input is valid
   public boolean validEntry(int enter){
        if (enter < 1 || enter > 100)
            return false;
        else
            return true;
   }
   
 // initialize the set with user input
    public void createSet(){
        int index = 0;
        int[] arr = new int[MAXSETSIZE];
        for (int i = 0; i < MAXSETSIZE; i++){
            System.out.print("Enter number (-1 to end): ");
            arr[index] = input.nextInt();
            // end the input
            if (arr[index] == -1)
            {
                arr[index] = 0;
                break;
            }
            // skip invalid input
            else if (arr[index] < 1 || arr[index] > 100){
                arr[index] = 0; 
                continue;
            }
            // if the input is correct
            else 
            {
                ++index;
            }
        }
        
        // copy the array in the integer set
        for (int i = 0; i < index; i++){
            this.intArray[i] = arr[i];
        }
        this.size = index;
        this.sortSet();
    }

// the function to sort the whole array
    public void sortSet(){
        int index = 0;
        Arrays.sort(this.intArray);
        for (int k = MAXSETSIZE - this.size; k < MAXSETSIZE; k++) 
        { 
            // Move the index ahead while  
            // there are duplicates 
            if (k < MAXSETSIZE - 1 && this.intArray[k] == this.intArray[k + 1]) {
                this.intArray[k] = 0;
                ++k; 
            }
            this.intArray[index] = this.intArray[k];
            ++index;
            this.intArray[k] = 0;
        }
        this.size = index;
    }
} 




/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
