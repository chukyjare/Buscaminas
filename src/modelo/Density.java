package modelo;

public class Density {
	private final byte easy=10; 
	private final byte hard=20;
	
	private byte level=easy;

	public Density(byte level) {
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

	public byte getHard() {
		return hard;
	}
	
}
