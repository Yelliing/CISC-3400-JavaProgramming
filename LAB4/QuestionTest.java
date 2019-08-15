

import java.util.Random;
import java.util.Scanner;

/**
 * QuestionTest is a test driver for the Question class.
 * 
 * @author Xiao Cai
 */
public class QuestionTest {
	   private static final int SEED = 13;
	   private static final Random randomNumbers = new Random(SEED);
	   
	   // create a new response
	   public static String createResponse(boolean correct) {
	      if (correct) {
	         switch (randomNumbers.nextInt(4)) {
	            case 0:
	               return("Very good!");

	            case 1:
	               return("Excellent!");

	            case 2:
	               return("Nice work!");

	            case 3:
	               return("Keep up the good work!");
	         } // end switch
	      }

	      // otherwise, assume incorrect
	      switch (randomNumbers.nextInt(4)) {
	         case 0:
	            return("No. Please try another.");

	         case 1:
	            return("Wrong. Try once more.");

	         case 2:
	            return("Don't give up!");

	         case 3: default:
	            return("No. Keep trying.");
	      }
	   }

	   /**
	    * main program - test the class Question by trying Questions with differing difficultyLevels and questionType
	    * @param args
	    */
	   public static void main(String[] args) {
	       int difficultyLevel, questionType;
	       
		   Scanner input = new Scanner(System.in);
		   
		   // TODO: Declare and allocate an array of Question objects.
		   Question[] aQuestion = new Question[5];
		   
		   for (int i = 0; i < 5; i++) 
		   {
			   // prompts the user to enter a grade level
			   System.out.print("Enter the difficulty level (1=single digits, 2=two digits, etc.): ");
			   
			   // TODO: Read in the difficulty Level. Let the Question class handle the correctness of the inputs
               difficultyLevel = input.nextInt();
               
			   System.out.print("Enter the question type (0=Any, 1=Addition, 2=Subraction, 3=Multiplication, 4=Division): ");
			   

			   // TODO: Read in the question type. Let the Question class handle the correctness of the inputs
			   questionType = input.nextInt();
			   
			   // TODO: Construct the Question object given the difficultyLevel and questionType.
			   Question curQuestion = Question.createQuestion(difficultyLevel, questionType);
               System.out.print(curQuestion.currentQuestion);
			   // TODO: Output the question.

			   System.out.print("Enter your answer: ");
			   
			   // Input the response.
			   double guess = input.nextDouble();
			   
			   // TODO: Use checkAndSetResponse to determine if correct or not and pass in the boolean to createResponse.
			   boolean correctnesst = curQuestion.checkAndSetResponse(guess);
			   String response = createResponse(correctnesst);

			   
			   // TODO: print out the String that is returned from createResponse.
			   System.out.println(response);
			   
			   // TODO: assign the question into the array.
			   aQuestion[i] = curQuestion;
			   
		   }
		   
		   System.out.println("\nHere are the questions that you answered: ");
		   // TODO: Loop and print the question objects in the array.
		   for (int i = 0; i <5; i++){
		       System.out.print(aQuestion[i].currentQuestion);
		       System.out.print(aQuestion[i].toString());
		   }
		   
	   }  

}

