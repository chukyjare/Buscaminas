package modelo;

public class Difficulty {
	private final byte easy=5; 
	private final byte normal=8; 
	private final byte hard=12;
	
	private byte level=easy;
	
	public Difficulty(byte level) {
		super();
		this.level = level;
	}

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public byte getEasy() {
		return easy;
	}

	public byte getNormal() {
		return normal;
	}

	public byte getHard() {
		return hard;
	}
	
	

	


}
