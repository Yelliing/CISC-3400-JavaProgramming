//package student;


/**
 * 
 * @author Xiao Cai
 *
 */
import java.util.Scanner;

public class DayOfWeek 
{
	// Constant with the extra values to add
	final static String MONTH_KEY_VALUE = "0144025036146";
	
	//default constructor
	public DayOfWeek(){
	
	}
	// TODO: Declare a constructor that meets the conditions
	/** 
	 * DayOfWeek class is an internal class to help the values of the parsed input.
	 * @param day
	 * @param month
	 * @param year
	 */
	 public DayOfWeek(int day, int month, int year){
	     this.year = year;
	     this.month = month;
	     this.day = day;
	 }
	
	// TODO: Declare Instance variables
	int year, month, day;
	
	// TODO: Declare getter methods
	public int getDay(){
	    return this.day;
	}  
	
	public int getMonth(){
	    return this.month;
	}     
	
	public int getYear(){
	    return this.year;
	}  
	

	
	// TODO: Declare a public static method DayOfWeek parseDate(String date)
	 /**
	  * parseDate - parses the date string into a DayOfWeek object.
	  * @param s input a string with format yyyy-dd-mm
	  * @return a DayOfWeek with the string parsed
	  */
	  public static void parseDate(String date,DayOfWeek Day1){
	      String[] parts = date.split("-");
	      String Syear = parts[0];
	      String Smonth = parts[1];
	      String Sday = parts[2];
	      //Day1 = new DayOfWeek(Integer.valueOf(Sday),Integer.valueOf(Smonth),Integer.valueOf(Syear));
	      Day1.year = Integer.valueOf(Syear);
	      Day1.month = Integer.valueOf(Smonth);
	      Day1.day = Integer.valueOf(Sday);
	      
	  }


	 /**
	  * isLeapYear inspects the DayOfWeek year to see if it is a leap year.
	  * 
	  * @return true if it's a leap year, false otherwise.
	  */
	 public boolean isLeapYear()
	 {
		 return ((year % 4) == 0) ? 
			  ((year % 100) == 0) ? ((year % 400) == 0) : false  : false;
	 }
   
	 /**
	  * get the name for the given day of week.
	  * @param day must be a number between 0-6 inclusive
	  * @return the String name for the day of week
	  * @throws IllegalArgumentException
	  */
	 public String getDayOfWeek(int day) throws IllegalArgumentException
	 {
		 final String[] dayNames = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday",
				 		"Thursday", "Friday" };
		 if (day < 0 || day > 6) {
			throw new IllegalArgumentException("Bad valur for day");
		 }
// 		 System.out.println("integer day of week is " + day);
		 return dayNames[day];
	 }
	 
	 // TODO: Define a method public int getDayOfWeek() that implements the defined algorithm
	 public int getDayOfWeek(DayOfWeek day1){
        //get the dates' numbers	   
	     int day = day1.getDay();
	     int month = day1.getMonth();
	     int year = day1.getYear();
         
	    //convert the key value to integer 
	     char key = day1.MONTH_KEY_VALUE.charAt(month);
	     int keyValue = Character.getNumericValue(key);
	     //calculate the year number
	     int yearNumber = ((year % 100) / 4);
	     yearNumber += day;
	     yearNumber+= keyValue;
	     
	     boolean Leap = day1.isLeapYear();
	     if (Leap){
	         if (month == 1 || month == 2)
	            {
	                --yearNumber;
	            }
	     }
	     int century = year / 100;
	     if (century % 4 == 0)  {yearNumber += 6;}
	     if ((century-1) % 4 == 0) {yearNumber += 4;}
	     if ((century-2) % 4 == 0) {yearNumber += 2;}
	     yearNumber += (year % 100);
	     yearNumber = yearNumber % 7;
	     return yearNumber;
	 }
	 
   /**
    * Test program for DayOfWeek class
    * @param args
    */
   public static void main(String[] args)
   {
        Scanner scan = new Scanner(System.in);
        String answer;
      // TODO: Implement a Loop for reading dates.
        do{
	        // TODO: Tell the user to enter a date and read it in
    	    System.out.println("Enter date ('yyyy-mm-dd'): ");
            //scan = new Scanner(System.in);
            String dateOfToday = scan.nextLine();
            
 	        // TODO: Call your static method parseDate to get a DayOfWeek object
            DayOfWeek today = new DayOfWeek();
            parseDate(dateOfToday, today);
            
 	        // TODO: Call your method getDayOfWeek() and print it in the output below.
 	        int Date = today.getDayOfWeek(today);
 	        String DateString = today.getDayOfWeek(Date);
 	        
            System.out.println("The algorithm says the day is '" +  DateString + "'");
 
 	        // TODO: Read in the users answer if they want to try again.
            System.out.print("Try again? (y or Y): ");
            answer = scan.nextLine();
        
        }while(answer.equals("y") || answer.equals("Y"));
        //end of while Loop
        System.out.println("Bye!");
   }
   
}
