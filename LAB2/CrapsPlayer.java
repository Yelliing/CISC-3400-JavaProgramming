//package students;
// Exercise 5.33: CrapsPlayer.java
// Craps class simulates the dice game craps.
import java.util.Random;
import java.util.Scanner;

public class CrapsPlayer {
   // create random number generator for use in method rollDice
   private static final int SEED = 40;
   private static final Random randomNumbers = new Random(SEED); 

   //declare instance variable
   int wager;
   double balance;
   
   //default constructor
   public CrapsPlayer(){
       this.wager = 0;
   }
   
   //constructor that takes a bank balance
   public CrapsPlayer(double balance){
       this.balance = balance;
       this.wager = 0;
   }
   
   //getter function for wager
   public int getWager(){
	    return this.wager;
	} 
	
	//setter function for wager
   public void setWager(int wager){
	    this.wager = wager;
	} 
	
   //getter function for balance
   public double getBalance(){
	    return this.balance;
	}
	
	//setter function for balance
   public void setBalance(int balance){
	    this.balance = balance;
	}
	
   // enumeration with constants that represent the game status
   private enum Status { CONTINUE, WON, LOST, BETWEEN_GAMES };

   // constants that represent common rolls of the dice
   private static final int SNAKE_EYES = 2;
   private static final int TREY = 3;
   private static final int SEVEN = 7;
   private static final int YO_LEVEN = 11;
   private static final int BOX_CARS = 12;


// allows the user to bet on games of Craps
   public static void main(String args[]) {
	  int wager = -1;

      // TODO: Construct a scanner for input
      Scanner scan = new Scanner(System.in);

      // TODO: Construct a new CrapsPlayer
      CrapsPlayer player1 = new CrapsPlayer(1000.00);
      
      double balance;
      do {
    	  balance = player1.getBalance();
         // TODO: Print the current balance using $%.2f to format the bank balance
   	     System.out.printf("Current balance is $%.2f%n", balance);
    	 
    	 // TODO: Prompt the user for a wager use
         System.out.printf("Enter wager (-1 to quit): ");
    	 
     	 // TODO: Read in a wager, make sure that it is a positive wager
    	 wager = scan.nextInt(); 

     	 // TODO: If it is a positive wager, make sure there is enough bank
     	 if (wager > 0){
     	 
       	 // TODO: If it is not a positive wager, skip and exit the game.
    	     if (wager > balance){
                 System.out.println("You don't have enough money!\n");
                 continue;
    	     }
    	     else{
    	         player1.play(wager);
    	     }
 
        // TODO: If the game is played, check to see if there is any bank left when done
        // TODO: If there is bank left, print some chatter using the chatter method.
            if (player1.balance <= 0){    
                 System.out.println("Sorry. You busted!");
                 System.exit(0);
            }
             else{
                player1.chatter();
            }
     	 }
     	 else{
             System.exit(0);
     	 }
             
        // TODO: Print a newline
        System.out.println();
            
      } while (wager > 0); // terminate if the user quits or runs out of money
      
   } 

   // TODO: Write an instance method to produce random chatter based on a randomNumber from 0-4.
    public void chatter(){
        int chatter = randomNumbers.nextInt(5);
        switch (chatter) {
         case 0: 
             System.out.println("Oh, you're going for broke huh?");
             break;
         case 1: 
             System.out.println("Aw, c'mon, take a chance!");
             break;
         case 2: 
             System.out.println("You're up big. Now's the time to cash in your chips!");
             break;
         case 3: 
             System.out.println("You're way too lucky!");
             break;
         case 4: 
             System.out.println("I'm betting all my money on you.");
             break;
         default:
            break;
        }
    }

   // TODO: Create a method public void play(int wager) to be an instance method
   public void play(int wager){
        this.setWager(wager);
        this.play();
   }


   // TODO: Modify method public void play() to be an instance method
   // TODO: Add processing of a wager, which is an instance variable.
   public void play() {
      int myPoint = 0; // point if no win or loss on first roll
      Status gameStatus; // can contain CONTINUE, WON or LOST

      int sumOfDice = this.rollDice(); // first roll of the dice

      // determine game status and point based on first roll 
      switch (sumOfDice) {
         case SEVEN: // win with 7 on first roll
         case YO_LEVEN: // win with 11 on first roll           
            gameStatus = Status.WON;
            break;
         case SNAKE_EYES: // lose with 2 on first roll
         case TREY: // lose with 3 on first roll
         case BOX_CARS: // lose with 12 on first roll
            gameStatus = Status.LOST;
            break;
         default: // did not win or lose, so remember point         
            gameStatus = Status.CONTINUE; // game is not over
            myPoint = sumOfDice; // remember the point
            System.out.printf("Point is %d%n", myPoint);
            break; 
      } 

      // while game is not complete
      while (gameStatus == Status.CONTINUE) { // not WON or LOST
         sumOfDice = this.rollDice(); // roll dice again

         // determine game status
         if (sumOfDice == myPoint) { // win by making point
            gameStatus = Status.WON;
         }
         else  {
            if (sumOfDice == SEVEN) { // lose by rolling 7 before point
               gameStatus = Status.LOST;
            }
         }
      }
      if (gameStatus == Status.WON){
          System.out.println("Player wins");
          this.balance += this.wager;
      }
      else if(gameStatus == Status.LOST){
          System.out.println("Player loses");
          this.balance -= this.wager;
      }
   } 

   /**
    * rollDice - rolls the dice and prints the turn.
    * @return the sum of the dice.
    */
   public static int rollDice() {
	  int sum = 0;           // sum of the die rolls
	  
	  // TODO: implement two die rolls
      int dice1 = 1 + randomNumbers.nextInt(6);
	  // TODO: sum of die values
      int dice2 = 1 + randomNumbers.nextInt(6);
      
      sum = dice1 + dice2;
      // TODO: display results of this roll.
      System.out.printf("Player rolled %d + %d = %d%n" , dice1, dice2, sum);

      return sum;
   } 

   
}


