package abi.record.problem.model;

public class AbiSong {
	
	int totalTimeSeconds;
	String songName;
	
	public AbiSong(String name, int seconds) {
		this.songName = name;
		this.totalTimeSeconds = seconds;
	}
	
	public String getSongName() {
		return this.songName;
	}
	
	// returns an int of the total seconds of the song
	public int getTotalSeconds() {
		return totalTimeSeconds;
	}
	
	
	// TODO: @ABI add in logic for time conversion here
	// returns an array with arr[0] as mins, and arr[1] as seconds
	public int[] getMinutesAndSeconds() {
		return null;
	}

}
