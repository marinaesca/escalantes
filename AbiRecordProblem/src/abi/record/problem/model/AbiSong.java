package abi.record.problem.model;

public class AbiSong {
	/* Note: useful resource on understanding enums
	 * https://dev.to/kylec32/effective-java-use-enums-instead-of-int-constants-5de3
	 */
	
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
