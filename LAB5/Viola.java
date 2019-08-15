//package jfugue.orchestra;

// TODO: Define public class Viola
public class Viola extends Instrument{
	private final String name = "Viola";
	private String notes;
	
	public Viola() {
		this(5, null);
	}
	
	public Viola(int octave, String notes) {
		super(octave, notes);
	}
	public void setNotes(String notes){
		String temp = new String();
		temp = notes.replaceAll("\\s", "5 ");		

		temp += "5";
		notes = temp;
		temp = notes.replaceAll("q5", "5q");
		notes = temp;
		temp = notes.replaceAll("i5", "5i");
		notes = temp;
		temp = notes.replaceAll("h5", "5h");
		notes = temp;
		temp = notes.replaceAll("w5", "5w");
		this.notes = temp;
	}
	public String getNotes() {
		return this.notes;
	}
}
