//package jfugue.orchestra;

import java.util.ArrayList;
import org.jfugue.player.Player;

// Class Orchestra contains a list of Members that have instruments.
public class Orchestra {
	// TODO: Declare instance variable to hold Members
	private ArrayList<Member> members;
	private int size;
	
	// TODO: Define a default constructor
	public Orchestra() {
		//initiate instance variables
		this.members = new ArrayList<Member>();
		size = 0;
	}
	// TODO: Define addMember(Member)
	public void addMember(Member member) {
		this.members.add(member);
		++size;
	}
	// TODO: Define getMembers() to return a list of Members
	public ArrayList<Member> getMembers() {
		return this.members;
	}
	
	public Member getLastMember() {
		return this.members.get(size-1);
	}
	
	// TODO: Define toString() to return the members in the String
	public String toString() {
		String output = new String();
		for (Member i : this.members){
			output += String.format("%s ", i.getName());
		}
		return output;
	}
	
	public int getSize() {
		return this.size;
	}
	
	// TODO: Define jfugueString() to return the playable string.
	// HINT: Consider using StringBuilder class to build the String.
	public String jfugueString() {
		String finalNotes = new String();
		for (int i = 0; i < getSize(); i++)
		{

			finalNotes += (String.format(" V%d ", i) + getMembers().get(i).getInstrument().toString());
		}
		return finalNotes;
	}
	
	
	// TODO: Define whoPlays(String instrument) to return a list of Member names
	public ArrayList<Member> whoPlays(String instrument){
		ArrayList<Member> instrumentPlayer = new ArrayList<Member>();
		for (int i = 0; i < members.size(); i++)
		{
			if (members.get(i).getInstrument().getName() == instrument)
				instrumentPlayer.add(members.get(i));
		}
		return instrumentPlayer;
	}


	// Method to play() the jfugueString()
	public void play() { 
		String jfugueString = jfugueString(); 
		Player player = new Player(); 
		player.play(jfugueString); 
	}
}
