//package jfugue.orchestra;

// TODO: Define public class Violin

public class Violin extends Instrument {
	private final String name = "Violin";
	private String notes;
	
	public Violin() {
		this(6, "");
	}
	
	public Violin(int octave, String notes) {
		super(octave, notes);
	}
	public void setNotes(String notes){
		String temp = new String();
		temp = notes.replaceAll("\\s", "6 ");		
		temp += "6";
		notes = temp;
		temp = notes.replaceAll("q6", "6q");
		notes = temp;
		temp = notes.replaceAll("i6", "6i");
		notes = temp;
		temp = notes.replaceAll("h6", "6h");
		notes = temp;
		temp = notes.replaceAll("w6", "6w");
		this.notes = temp;
	}
	public String getNotes() {
		return this.notes;
	}

}