

//package jfugue.orchestra;
public class Contrabass extends Instrument {
	private final String name = "Contrabass";
	private String notes;
	public Contrabass() {
		this(3, null);
	}
	public Contrabass(int octave, String notes) {
		super(octave, notes);
	}
	
	public void setNotes(String notes){
		String temp = new String();
		temp = notes.replaceAll("\\s", "3 ");		
		temp += "3";
		notes = temp;
		temp = notes.replaceAll("q3", "3q");
		notes = temp;
		temp = notes.replaceAll("i3", "3i");
		notes = temp;
		temp = notes.replaceAll("h3", "3h");
		notes = temp;
		temp = notes.replaceAll("w3", "3w");
		this.notes = temp;
	}
	public String getNotes() {
		return this.notes;
	}

}




