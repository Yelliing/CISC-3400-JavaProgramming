//package jfugue.orchestra;

import java.util.Scanner;

public class JFugueMusic {

	public static Member newMember(String name, int instNum) {
		Member newMember = new Member();
		newMember.setName(name);
		
		switch(instNum) {
			case 1:
				Instrument newInstrument = new Violin();
				newMember.setInstrument(newInstrument);
				break;
			case 2:
				Instrument newInstrument1 = new Viola();
				newMember.setInstrument(newInstrument1);
				break;
			case 3:
				Instrument newInstrument2 = new Cello();
				newMember.setInstrument(newInstrument2);
				break;	
			case 4:
				Instrument newInstrument3 = new Contrabass();
				newMember.setInstrument(newInstrument3);
				break;
			default:
				break;
		}
		return newMember;
		
	}
	
	public static void main(String[] args) {
		// TODO: Declare a scanner for reading.
		Scanner input = new Scanner(System.in);
		String finalNotes = new String();
		String answer = new String();
		String name = new String();
		String notes = new String();
		int instNum = 0;
		// TODO: Declare a loop control variable
		Orchestra orchestra = new Orchestra();
		// TODO: Create a loop that allows multiple
		do 
			// TODO: Construct an Orchestra
		{
			
			System.out.println("Create an orchestra with no more than 15 instruments.");
			
			// TODO: Create a loop that allows up to 15 members to be created
			do {
				System.out.print("Enter member name: ");
				
				// TODO: Input the name.
				name = input.next();
				
				// TODO: Use the number as input and map it to the class in a switch statement.
				System.out.print("\t1) Violin\n\t2) Viola\n\t3) Cello\n\t4) Contrabass\nEnter member instrument: ");
				
				instNum = input.nextInt();
				while(instNum >4 || instNum < 1) {
					System.out.print("Wrong input please try again.\n");
					instNum = input.nextInt();
				}
				// TODO: Write a function that takes a member name and instrument number and returns a member.

				Member member = newMember(name, instNum);
				
				
				// TODO: Make sure there is a valid member

					
					// TODO: Read the left-over newline.
				notes = input.nextLine();
					
				System.out.println("Enter notes: ");
				
					
					// TODO: Read the line of notes.
				
				notes = input.nextLine();	
					
					// TODO: Set the Notes in the member's instrument.
				member.getInstrument().setNotes(notes);
					
					// TODO: Add the member to the orchestra
				orchestra.addMember(member);

				System.out.print("Another? (y or n): " );
				answer = input.next();
			}while(answer.equalsIgnoreCase("Y") && orchestra.getSize() < 16);
				
				// TODO: Create the while condition.

			
			// TODO: Print out the jfugueString first, then play it.
			finalNotes = orchestra.jfugueString();
			System.out.println(finalNotes);
			orchestra.play();

			System.out.println("Again? (y or n): ");
			answer = input.next();
		}while(answer.equalsIgnoreCase("Y"));
			// TODO: Create the outer loop while condition.

	}

}
