package abi.record.problem.model;

public enum RecordSize {
	// NOTE: Format - RecordSize(int minutes, double price)
	SMALL(6, 4.0),
	MEDIUM(10, 8.0),
	LARGE(12, 10.0),
	EXTRALARGE(15, 12.00);
	
	private final int minutes;
	private final int seconds;
	private final double price;
	
	private static final int secondsInMinute = 60;
	
	RecordSize(int minutes, double price) {
		this.minutes = minutes;
		this.seconds = minutes * secondsInMinute;
		this.price = price;
	}
	
	public int minutes() {
		return minutes;
	}
	
	// NOTE: Sizes / Seconds / Minutes:
	//		SECONDS: 360, 600, 720, 900
	//      MINS: 6, 10, 12, 15
	public int seconds() {
		return seconds;
	}
	
	public double price() {
		return price;
	}

}
