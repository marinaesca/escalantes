package abi.record.problem.model;

import java.util.ArrayList;


public class AbiRecord {
	public enum AbiRecordEnum {
		SMALL, MEDIUM, LARGE, EXTRALARGE
	};
	// Sizes / Seconds / Minutes:
	//		SECONDS: 360, 600, 720, 900
	//      MINS: 6, 10, 12, 15
	
	AbiRecordEnum recordSize;
	int totalTimeSeconds;
	double price;
	/* NOTE: A Java arraylist is very similar to an array, but uses methods
	   instead of direct indexing. For adding you will do songs.add(x)
	   instead of songs[0] = x. The main thing that changes is that you use 
	   methods instead of brackets to index into the array directly. For 
	   example to access a value you will do songs.get(index). The reason we
	   are using a list instead of a regular Java array is because it will
	   resize for us. So instead of having to know the total number of songs
	   in advance, or having to create a new array and update when our size 
	   changes, a Java arraylist will resize for us under the hood. 
	*/
	private ArrayList<AbiSong> sideAsongs;
	private ArrayList<AbiSong> sideBsongs;
	
	
	// CONSTRUCTOR - creates a new AbiRecord with details and can be given a tracklist
	public AbiRecord(AbiRecordEnum recordSize, double price) {
		this.recordSize = recordSize;
		this.price = price;
		
		switch (recordSize) {
			case SMALL:
				this.totalTimeSeconds = 360; // 360 seconds, 6 mins
			case MEDIUM:
				this.totalTimeSeconds =  600; // 600 seconds, 10 mins
			case LARGE:
				this.totalTimeSeconds =  720; // 720 seconds, 12 mins
			case EXTRALARGE:
				this.totalTimeSeconds =  900; // 900 seconds, 15 mins
		}
	}
	
	public boolean isEmpty() {
		return sideAsongs.isEmpty() && sideBsongs.isEmpty();
	}
	
	// temp example: size = small
	//  size: small, total_time: 6 minutes: total_time_seconds: 360, price: $10
	
	
	
	// Add a song implementation, and allow users to add songs to the record
	public boolean addSong(String name, int totalSeconds, char side) {
		if (side != 'a' && side != 'b') {
			// invalid side, we can't add a song
			return false;
		}
		
		AbiSong newSong = new AbiSong(name, totalSeconds);
		if (side == 'a') {
			this.sideAsongs.add(newSong);
			return true;
		} else {
			this.sideBsongs.add(newSong);
			return true;
		}
	}
	
	// Remove a song implementation, and allow users to remove songs 
	//   from the record based on song index
	public boolean addRemoveSong(int songIndex, char side) {
		if (side != 'a' && side != 'b') {
			// invalid side, we can't remove a song
			return false;
		}
		
		
		if (side == 'a') {
			this.sideAsongs.remove(songIndex);
			return true;
		} else {
			this.sideBsongs.remove(songIndex);
			return true;
		}
	}
	
	
}
