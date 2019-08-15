//package jfugue.orchestra;

// Orchestras have Members and Members have an Instrument.
public class Member {
	// TODO: Declare instance variables
	private Instrument instrument;
	private String name;
	
	// TODO: Define constructors
	public Member() {
		//this.instrument = new Instrument();
	}
	
	public Member(String name) {
		this.name = name;
		//this.instrument = new Instrument();		
	}
	
	public Member(String name, Instrument instrument) {
		this.name = name;
		this.instrument = instrument;		
	}
	
	// TODO: Implement Accessors and Mutators.
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	public Instrument getInstrument() {
		return this.instrument;
	}
	
}
