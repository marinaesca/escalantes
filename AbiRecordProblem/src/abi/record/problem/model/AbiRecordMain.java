package abi.record.problem.model;

import java.util.Scanner;

//import java.awt.*;
import javax.swing.*;

public class AbiRecordMain {
	public static final Scanner reader = new Scanner(System.in);
	
	public static void main (String[] args ){
		
		printIntroAndDescription();
		RecordSize recordSize = inputSizeSelection();
		visuals();
	}
	
	public static void visuals() {
		
		/* GRAPHICS / 2D VISUALS
		 * Simple Java oracle docs references:
		 *    https://docs.oracle.com/javase/tutorial/2d/basic2d/index.html
		 * Best comprehensive reference: 
		 *    https://books.trinket.io/thinkjava/appendix-b.html
		 * Java Swing API Visual:
		 *    https://www.javatpoint.com/java-swing#:~:text=Hierarchy%20of%20Java%20Swing%20classes
		 */
		
//		DrawingPanel p1 = new DrawingPanel(1200, 600);
//		Graphics g = p1.getGraphics();
		
//		JFrame f= new JFrame();  
//        JTextArea area=new JTextArea(AbiProblemText.getIntroAndDescriptionText());  
//        area.setBounds(10,30, 200,200);  
//        f.add(area);  
//        f.setSize(300,300);  
//        f.setLayout(null);  
//        f.setVisible(true);  
		
		
	}
	
	public static void printIntroAndDescription() {
		System.out.println(AbiProblemText.getIntroAndDescriptionText());
		
		
		/* TODO: @ABI prettify this by making the spacing between size, 
		 *	minutes, and price have clean spacing
		 *	ex:
		 *		Size: SMALL   Capacity in minutes 6 ...
		 *		Size: MEDIUM  Capacity in minutes 10 ...
		 *		Size: LARGE   Capacity in minutes 12 ...
		 *	hint: calculate the char length of all the values for a given
		 *	column, and then for spacing take the max + 1 for a space
		 *	then start the next column at the determined spacing
		 */
		
		RecordSize[] sizeOptions = RecordSize.values();
		for (int i = 0; i <sizeOptions.length; i++) {
			RecordSize currentSize = sizeOptions[i];
			System.out.print("Size: " + currentSize.toString() + " ");
			System.out.print("Capacity in minutes: " + currentSize.minutes() + " ");
			System.out.print("Price: " + currentSize.price() + "\n");
		}
		System.out.println();  // NOTE: this is just for spacing
	}
	
	/* collects a record size from the user
	 * max of 10 tries, then we just return null to prevent infinite loop
	 */
	
	public static RecordSize inputSizeSelection() {
		System.out.println("Which size would you like? ");
		
		int maxTriesTimeout = 10;
		int tries = 0;
		
		boolean sizeCollected = false;
		while(!sizeCollected && tries < maxTriesTimeout && reader.hasNextLine()) {
			String userInputSize = reader.nextLine();
			
			RecordSize[] sizeOptions = RecordSize.values();
			for (int i = 0; i <sizeOptions.length; i++) {
				// NOTE: we want to be nice and helpful so we should expand our
				//   input to allow size in uppercase, lowercase, and just the
				//   first letter of the size string
				
				RecordSize currentSize = sizeOptions[i];
				String sizeStr = currentSize.toString();
				
				if (userInputSize.equals(sizeStr) 
						|| userInputSize.equals(sizeStr.toLowerCase())
						|| userInputSize.equals(Character.toString(sizeStr.toLowerCase().charAt(0)))
					){
					sizeCollected = true;
					return currentSize;
				}
			}
			
			// The user input was faulty, let them know, prompt for new input
			System.out.println("That is not a valid size, please try again.");
			tries++;
			
		}
		return null;
		
	}

}
