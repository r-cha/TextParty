import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	
	Scanner readIn;
	FileWriter fstream;
	BufferedWriter writeOut;
	String displayOptions[] = {"Read from file", "See file history", "Exit program"};
	String noPunctuation = ""; //File with punctuation removed
	String inFile = ""; //File name being read
	int numLines = 0; //number of lines in file
	int blankLines = 0; //number of blank lines in file
	int numWords = 0; //total number of words in file
	double avgWordLength = 0; //average word length
	double avgCharLines = 0; //average characters per line
	ArrayList<String> mostCommonWords = new ArrayList<String>(); //list of the most commonly occurring words in the file

	public Main() {
		
		openSave();
		
		int choice;
		
		while (true) {
		
			choice = JOptionPane.showOptionDialog(null, "Choose a function", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, displayOptions, null);
			switch (choice) {
			case 0:
				clearVars();
				inFile = JOptionPane.showInputDialog("Enter file name (include suffix)");
				if (readFile(inFile))
					output();
				break;
			case 1:
				break;
			default:
				return;
			}
		
		}
		
	}
	
	//Opens or creates the save file
	public void openSave() {
		
		try {
			
			readIn = new Scanner(new FileReader("saveFile.txt"));
		
		} catch (Exception e) {
			
			//Creates a new save file if one does not already exist
			try {
				
				fstream = new FileWriter("saveFile.txt");
				writeOut = new BufferedWriter(fstream);
				writeOut.write("");
				
			} catch (Exception excep) {
				
				excep.printStackTrace();
			
			}
			
		}
		
	}
	
	public boolean readFile (String fileName) {
		
		Scanner in;
		ArrayList<String> fileLines = new ArrayList<String>();
		ArrayList<Object> wordCount = new ArrayList<Object>(); //index = word, index + 1 = number of times word occurs
		
		//returns true if file was successfully opened and operated on
		try {
			
			in = new Scanner(new FileReader(fileName));
			String completeFile = "";
			while(in.hasNextLine())
				fileLines.add(in.nextLine());
			
			//Finding the number of lines in the file
			numLines = fileLines.size();
			
			//Finding the average characters per line
			int totalChars = 0;
			for (String s : fileLines) {
				
				totalChars += s.length();
				completeFile += s;
				completeFile += "\n";
				
			}
			avgCharLines = (double)totalChars / numLines;
			
			//Finding the most commonly occurring words and number of blank lines
			int highOccur = 0;
			for (String line : fileLines){
				
				if (line.equals("")) {
					
					blankLines++;
					continue;
					
				}
				
				String word[] = line.split("\\.| ");
				
				for (int index = 0; index < word.length; index++) {
					
					//If word is already in the list it increases the number of times it has occurred
					if (wordCount.contains(word[index])) {
						
						int replaceIndex = wordCount.indexOf(word[index]) + 1;
						int value = (Integer)wordCount.get(replaceIndex) + 1;
						wordCount.set(replaceIndex, value);
						if (value > highOccur)
							highOccur = value;
						
					}
					
					else {
						
						wordCount.add(word[index]);
						wordCount.add(1);
						if (1 > highOccur)
							highOccur = 1;
						
					}
					
				}
				
			}
			
			int totWordLength = 0;
			
			//Finds total number of words, builds list of most common words, and the total number of characters in words
			for (int index = 1; index < wordCount.size(); index += 2) {
					
				int numOccur = (Integer)wordCount.get(index);
				String curWord = (String)wordCount.get(index - 1);
				
				//Finds the total number of words
				numWords += numOccur;
				
				//If word is one of the most occurring it adds it to mostCommonWords
				if (numOccur == highOccur)
					mostCommonWords.add(curWord);
				
				totWordLength += curWord.length() * numOccur;
				
			}
			
			//Finding average word length
			avgWordLength = (double)totWordLength / numWords;
			
			//Removes punctuation
			String noPunct[] = completeFile.split("\\p{Punct}");
			for (String s : noPunct)
				noPunctuation += s;
			
			in.close();
			return true;
			
		} catch (FileNotFoundException e) {
			
			//returns false and throws error if file was not read and operated on
			System.out.println("Failed to read file");
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	//zeros and clears all variables to prepare for new file
	public void clearVars() {
		
		noPunctuation = "";
		numLines = 0;
		avgCharLines = 0;
		blankLines = 0;
		numWords = 0;
		avgWordLength = 0;
		mostCommonWords.clear();
		
	}
	
	public void output() {
		
		String results = "Successfully read " + inFile + "\n" +
							"Total number of lines: " + numLines + "\n" +
							"Total number of blank lines: " + blankLines + "\n" +
							"Average characters per line: " + avgCharLines + "\n" +
							"Total number of words: " + numWords + "\n" +
							"Average word length: " + avgWordLength + "\n" +
							"Most common words: " + mostCommonWords + "\n" +
							"File without punctuation: \n" + noPunctuation;
		
		JOptionPane.showMessageDialog(null, results);
		
	}
	
	//Entry point
	public static void main(String[] args) {
		
		new Main();

	}

}