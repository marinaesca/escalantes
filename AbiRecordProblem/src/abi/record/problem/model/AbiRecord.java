package abi.record.problem.model;

import java.util.Dictionary;


public class AbiRecord {
	public enum AbiRecordEnum {
		SMALL, MEDIUM, LARGE, EXTRALARGE
	};
	// Sizes / Seconds / Minutes:
	//		SECONDS: 360, 600, 720, 900
	//      MINS: 6, 10, 12, 15
	
	AbiRecordEnum record_size;
	int total_time_seconds;
	double price;
	private Dictionary<String, Integer> songs;
	
	// Phase 2: update songs to be sideasongs and sidebsongs
	// private Dictionary<String, Integer> sideasongs;
	// private Dictionary<String, Integer> sidebsongs;
	
	// CONSTRUCTOR - creates a new AbiRecord with details and can be given a tracklist
	public AbiRecord(AbiRecordEnum record_size, double price) {
		this.record_size = record_size;
		this.price = price;
		
		switch (record_size) {
			case SMALL:
				this.total_time_seconds = 360; // 360 seconds, 6 mins
			case MEDIUM:
				this.total_time_seconds =  600; // 600 seconds, 10 mins
			case LARGE:
				this.total_time_seconds =  720; // 720 seconds, 12 mins
			case EXTRALARGE:
				this.total_time_seconds =  900; // 900 seconds, 15 mins
		}
	}
	
	public boolean isEmpty() {
		return songs.isEmpty();
	}
	
	// temp example: size = small
	//  size: small, total_time: 6 minutes: total_time_seconds: 360, price: $10
	
	
	
	// TODO: -------------------------
	// Add a song implementation, and allow users to add songs to the record
	// Phase 2: allow for adding to a particular side (side A or side B)
	public void addSong() {
		
	}
	
	
}
