//package cai;
// Exercise 5.38 Solution: Question.java
// Program generates single-digit multiplication problems
import java.util.Random;
import java.util.Scanner;

/**
 * Question class creates a Question object given a difficultyLevel and questionType
 * Stores the operands, question, answer and response for auditing results.
 * @author 
 */
public class Question {
   private static final int SEED = 13;
   public  static final int ADDITION=1;
   public  static final int SUBTRACTION=2;
   public  static final int MULTIPLICATION=3;
   public  static final int DIVISION=4;
   private static final Random randomNumbers = new Random(SEED);
   // TODO: declare difficulty level set by the user
   int difficulty;
   // TODO: declare question type set by the user
   int question;
   // TODO: declare the current answer
   double answer;
   // TODO: delcare the current question
   String currentQuestion;
   // TODO: declare the current operand1
   int operand1;
   // TODO: declare the current operand2
   int operand2;
   // TODO: declare response which contains the user given response
   double response;
   
   
   /**
    * TODO: default constructor delegates construction using 0, 0
    */
    public Question(){
        this.difficulty = 0;
        this.question = 0;
    }
   
   /**
    * TODO: constructor delegates construction using type, 0
    * @param questionType
    */
    public Question(int questionType){
        this.difficulty = 0;
        this.question = questionType;
    }
   
   /**
    * TODO: constructor checks inputs and defaults to 0 if inputs are invalid
    * @param difficultyLevel
    * @param questionType
    */
    public Question(int difficultyLevel, int questionType){
        //check for difficulty level value
        if (difficultyLevel > 0 && difficultyLevel<5){
            this.difficulty = difficultyLevel;
        }
        else{
            this.difficulty = randomNumbers.nextInt(4) + 1;
        }
        //check for question type value
        if (questionType > 0 && questionType <5) {
            this.question = questionType;
        }
        else{
            this.question = randomNumbers.nextInt(4) + 1;
        }
    }
    
   
   // TODO: toString()
   // prints a new question and stores the corresponding answer
   //@Override
   public String toString(){
       if (this.answer == this.response){
           return String.format(" It's %.2f\n", this.getResponse());
       }
       else{
           return String.format(" It's %.2f not %.2f\n", this.answer, this.response);
       }
   }

   // TODO: implement getQuestionType
   public int getQuestionType(){
       return this.question;
   }

   // TODO: implement getDifficultyLevel
   public int getDifficultyLevel(){
       return this.difficulty;
   }
   
   // TODO: implement getOperand1
   public int getOperand1(){
       return this.operand1;
   }
   
   // TODO: implement getOperand2
   public int getOperand2(){
       return this.operand2;
   }
   
   // TODO: implement getAnswer
   public void getAnswer(){
       String questionType = this.getQuestion();
       double answer = 0;
       switch (questionType){
           case "+":
               answer = (this.operand1 + this.operand2);
               break;
           case "-":
               answer = (this.operand1 - this.operand2);
               break;
           case "*":
               answer = (this.operand1 * this.operand2);
               break;
           case "/":
               double current = (double)this.operand1 / (double)this.operand2;
               answer = (double)Math.round(current * 10000d) / 10000d;
               break;
           default:
               break;
       }
       this.answer = answer;
    //   return answer;
   }
   
   // TODO: implement getQuestion
   public String getQuestion(){
       String symbol;
       switch (this.question) {
           case 1:
               symbol = "+";
               break;
           case 2: 
               symbol = "-";
               break;
           case 3:
               symbol = "*";
               break;
           case 4:
               symbol = "/";
               break;
            default:
               symbol = "";
               break;
       }
       return symbol;
   }
   
   // TODO: implement getResponse
   public double getResponse(){
       return this.response;
   }
   
   // TODO: implement setDifficultyLevel
   public void setDifficultyLevel(int difficultyLevel){
       this.difficulty = difficultyLevel;
   }
   
   // TODO: implement setQuestionType
   public void setQuestionType(int questionType){
       this.question = questionType;
   }
   // TODO: implement checkAndSetResponse - sets response
   // @param response double 
   // @return boolean true if response is correct, false otherwise
   public boolean checkAndSetResponse(double response){
       this.response = response;
       return (response == this.answer) ? true : false;
   }
   

   // pick random number in the range start to end - 1
   public static int getRandomNumberInRange(int start, int end) {
      int number;

      do {
         number = randomNumbers.nextInt(end);
      } while (number < start);

      return number;
   }
   
   
   /**
    * TODO: createQuestion - A static Factory method to create an instance using
    * @param difficultyLevel
    * @param questionType
    * @return a Question object that has already called createQuestion and is ready to go.
    */
    public static Question createQuestion(int difficultyLevel, int questionType){
        Question question1 = new Question(difficultyLevel, questionType);
        question1.createQuestion();
        return question1;
    }
   
   /**
    * TODO: createQuestion - An instance method to create the question by 
    * taking the difficultyLevel using randomNumbers to determine the operands
    * remember that a difficultyLevel of 1 uses operands 0-9
    * remember that a difficultyLevel of 2 uses operands 10-99
    * use the questionType to determine the question asked.
    * compute the answer.
    * @return the Question
    */
   public Question createQuestion() {
	   // TODO: first get the range using the difficultyLevel and the Math.pow function
	   int base = (int)Math.pow(10, this.getDifficultyLevel()-1);
	   int range =(int)Math.pow(10, this.getDifficultyLevel())-1;
	   // TODO: set the two operands to random numbers from 0 up to range
       this.operand1 = this.getRandomNumberInRange(base, range);
       this.operand2 = this.getRandomNumberInRange(base, range);
	   // TODO: use questionType to determine the question and compute answer
	   //if (this.question < 1 || this.question >4){
	   //    this.question = randomNumbers.nextInt(4) + 1;
	   //}
	   this.getAnswer();
	   
	   String questionType = this.getQuestion();
       
	   // TODO: use the following Strings to create the questions. 
	   switch (questionType){
	   case "+":
	       this.currentQuestion = String.format("How much is %d plus %d?\n", operand1, operand2);
           break;
       case "-":
	       this.currentQuestion = String.format("How much is %d minus %d?\n", operand1, operand2);
           break;
	   case "*":
	       this.currentQuestion = String.format("How much is %d times %d?\n", operand1, operand2);
           break;
       case "/":
	       this.currentQuestion = String.format("How much is %d divided by %d?\n", operand1, operand2);
	       break;
	   default:
	       break;
	   }
	   return this;
   }
   
}


