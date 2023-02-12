package abi.record.problem.model;

import java.util.ArrayList;


public class AbiRecord {
	
	RecordSize recordSize;
	int totalTimeSecondsPerSide;
	int totalCurrentSeconds;
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
	   Docs: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
	*/
	private ArrayList<AbiSong> sideAsongs;
	private ArrayList<AbiSong> sideBsongs;
	
	
	// CONSTRUCTOR - creates a new AbiRecord with details and can be given a tracklist
	public AbiRecord(RecordSize recordSize) {
		this.recordSize = recordSize;
		
		switch (recordSize) {
			case SMALL:
				this.totalTimeSecondsPerSide = RecordSize.SMALL.seconds();
				this.price = RecordSize.SMALL.price();
			case MEDIUM:
				this.totalTimeSecondsPerSide = RecordSize.MEDIUM.seconds();
				this.price = RecordSize.MEDIUM.price();
			case LARGE:
				this.totalTimeSecondsPerSide =  RecordSize.LARGE.seconds();
				this.price = RecordSize.LARGE.price();
			case EXTRALARGE:
				this.totalTimeSecondsPerSide =  RecordSize.EXTRALARGE.seconds();
				this.price = RecordSize.EXTRALARGE.price();
		}
	}
	
	public boolean isEmpty() {
		return sideAsongs.isEmpty() && sideBsongs.isEmpty();
	}
	
	// Add a song implementation, and allow users to add songs to the record
	public boolean addSong(String name, int totalSeconds, char side) {
		// preconditions: verify side validity
		if (!sideCheck(side)) {
			return false;
		}
		
		// TODO: add in logic to prevent updating a song if the time of the
		//   song is too long and will not fit in the record side total size
		
		AbiSong newSong = new AbiSong(name, totalSeconds);
		if (side == 'a') {
			this.sideAsongs.add(newSong);
		} else {
			this.sideBsongs.add(newSong);
		}
		return true;
	}
	
	// Remove a song implementation, and allow users to remove songs 
	//   from the record based on song index
	public boolean removeSong(int songIndex, char side) {
		// preconditions: verify side validity
		if (!sideCheck(side)) {
			return false;
		}
		
		
		if (side == 'a') {
			this.sideAsongs.remove(songIndex);
		} else {
			this.sideBsongs.remove(songIndex);
		}
		return true;
	}
	
	public boolean updateSong(int songIndex, String name, int totalSeconds, char side) {
		// preconditions: verify side validity
		if (!sideCheck(side)) {
			return false;
		}
		
		// TODO: add in logic to prevent updating a song if the time of the song
		//   is too long and will not fit in the record side total size
		
		AbiSong newSong = new AbiSong(name, totalSeconds);
		if (side == 'a') {
			this.sideAsongs.set(songIndex, newSong);
			
		} else {
			this.sideBsongs.set(songIndex, newSong);
		}
		return true;
	}
	
	// checks whether the given char is 'a' or 'b' aka a valid record side
	private boolean sideCheck(char side) {
		return (side == 'a' || side == 'b');
	}
	
	// 
	private int getCurrentSecondsForSide(char side) {
		// preconditions: verify side validity
		if (!sideCheck(side)) {
			return -1;
		}
		
		int tempSum = 0;
		
		if (side == 'a') {
			for (int i = 0; i < this.sideAsongs.size(); i++) {
				int tempSongSeconds = this.sideAsongs.get(i).getTotalSeconds();
				tempSum += tempSongSeconds;
			}
		} else {
			for (int i = 0; i < this.sideBsongs.size(); i++) {
				int tempSongSeconds = this.sideBsongs.get(i).getTotalSeconds();
				tempSum += tempSongSeconds;
			}
		}
		return tempSum;
		
	}
	
	public double getPrice() {
		return this.price;
	}
	
}
