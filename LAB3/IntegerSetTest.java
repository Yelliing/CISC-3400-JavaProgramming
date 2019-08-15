//package projects.intset;
// Exercise 8.13 Solution: IntegerSetTest.java
// Program that tests IntegerSet
import java.util.Scanner;

public class IntegerSetTest {
	public static final Scanner input = new Scanner(System.in);
	
	// TODO: Follow the prompts and implement the program.
   public static void main(String[] args) {
      // initialize two sets
      IntegerSet setA = new IntegerSet();
      IntegerSet setB = new IntegerSet();
      System.out.println("Input Set A");
      setA.createSet();
      System.out.println("Input Set B");
      setB.createSet();
      // TODO: Perform the union of setA and setB to create a third IntegerSet.
      IntegerSet setC = new IntegerSet();
      setC.unionSet(setA, setB);
      
      // TODO: Perform the intersection of setA and setB to create a third IntegerSet
      IntegerSet setD = new IntegerSet();
      setD.intersectionSet(setA, setB);
      // TODO: Call your IntegerSet toString() methods below
      System.out.println("Set A contains:");
      System.out.print(setA.toString());
      
      System.out.println("Set B contains:");
      System.out.print(setB.toString());

      System.out.println("Union of A and B contains:");
      System.out.print(setC.toString());
      
      System.out.println("Intersection of A and B contains:");
      System.out.print(setD.toString()); 

      // TODO: Compare two sets to see whether they are equal, see the test cases for
      // output formatting.

      if (setA.equalSet(setB)){
          System.out.println("Set A is equal to set B.");
      }
      else{
          System.out.println("Set A is not equal to set B");
      }

      // TODO: test insert and delete the integer 77
      System.out.println("Inserting 77 into set A...");
      setA.insertValue(77);
      
      System.out.println("Inserting 105 into set A...");
      setA.insertValue(105);
      
      System.out.println("Set A now contains:");
      System.out.print(setA.toString());
      
      System.out.println("Deleting 77 from set A...");
      setA.deleteValue(77);
      
      System.out.println("Deletinging 105 into set A...");
      setA.deleteValue(105);
     

      System.out.print(setA.toString());
      
      System.out.println("Deleting 88 from set A...");
      setA.deleteValue(88);
      
      System.out.println("Set A now contains elements:");
      System.out.print(setA.toString());
      // TODO: A unit test will be constructed that calls validEntry.
      

      // test constructor
      int[] intArray = {25, 67, 2, 9, 99, 105, 45, -5, 100, 1, 99, 25};
      IntegerSet setE = new IntegerSet(intArray);

      System.out.println("New Set contains elements:");
      System.out.print(setE.toString());
      
   } 
}


