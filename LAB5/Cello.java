//package jfugue.orchestra;

public class Cello extends Instrument {
	private final String name = "Cello";
	private String notes;
	public Cello() {
		this(4, null);
	}
	
	public Cello(int octave, String notes) {
		super(octave, notes);
	}
	
	public void setNotes(String notes){
			String temp = new String();
			temp = notes.replaceAll("\\s", "4 ");	
			temp += "4";
			notes = temp;
			temp = notes.replaceAll("q4", "4q");
			notes = temp;
		    temp = notes.replaceAll("i4", "4i");
			notes = temp;
			
			temp = notes.replaceAll("h4", "4h");
			notes = temp;
			temp = notes.replaceAll("w4", "4w");
			this.notes = temp;
	}
	public String getNotes() {
		return this.notes;
	}
}
