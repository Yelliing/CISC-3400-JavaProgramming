//package jfugue.orchestra;


public abstract class Instrument {
	// TODO: Declare instance variables
	private int octave;
	private String notes = new String();
	// TODO: Finish implememting the consructor given an octave
	// @param the octave is fixed for a given instrument
	public Instrument() {
		
	}
	
	public Instrument(int octave) {
		this.octave = 0;
	}
	
	// TODO: Finish implementing the constructor given an octave and notes
	public Instrument(int octave, String notes) {
		
		this.octave = octave;
		this.notes = notes;
//		this.notes = notes.replaceAll("\\s", String.format(" %d",octave));	
		
	}
	
	// TODO: Accessor and Mutator methods
	public abstract String getNotes();
	
	public abstract void setNotes(String notes);
	
	
	// Method to return the name of the instrument.
	// #return name
	public String getName() {
		String[] path = getClass().getName().split("\\.");
		return path[path.length-1];
	}

	// TODO: Use toString() to print jfugueString() for the orchestra.
	// TODO: remember that getNotes has to include the octave for every note.
	public String toString() {
		return String.format("I[%s] %s", getName(), getNotes());
	}
	

}
