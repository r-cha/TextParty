import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ActiveFile {

	private Scanner readIn;
	private FileWriter fstream;
	private BufferedWriter writeOut;
	private String noPunctuation; //File with punctuation removed
	private String fileName; //File name being read
	private int numLines; //number of lines in file
	private int blankLines; //number of blank lines in file
	private int numWords; //total number of words in file
	private int numSpaces;
	private double avgWordLength; //average word length
	private double avgCharLines; //average characters per line
	private ArrayList<String> mostCommonWords; //list of the most commonly occurring words in the file
	private ArrayList<String> fileLines;
	ArrayList<Object> wordCount; //index = word, index + 1 = number of times word occurs
	private String completeFile;

	public ActiveFile() {
		noPunctuation = "";
		fileName = "";
		numLines = 0;
		blankLines = 0;
		numWords = 0;
		avgWordLength = 0;
		avgCharLines = 0;
		mostCommonWords = new ArrayList<String>();
		fileLines = new ArrayList<String>();
		wordCount = new ArrayList<Object>();
		completeFile = "";
		numSpaces = 0;
	}

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

	public void openFile() {
		try {
			
			readIn = new Scanner(new FileReader(fileName));
			while(readIn.hasNextLine())
				fileLines.add(readIn.nextLine());
			readIn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void analyze() {
		
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
		avgWordLength = (double) totWordLength / numWords;
		
	}
	
	public void removePunctuation() {
		
		String noPunct[] = completeFile.split("\\p{Punct}");
		for (String s : noPunct)
			noPunctuation += s;
		
	}
	
	/*
	 * Getters
	 */
	
	public int getNumLines() {
		return this.numLines;
	}
	
	public int getBlankLines() {
		return this.blankLines;
	}
	
	public int getNumWords() {
		return numWords;
	}
	
	public int getNumSpaces() {
		return numSpaces;
	}
	
	public double getWordLength() {
		return avgWordLength;
	}
	
	public double getCharLines() {
		return avgCharLines;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public ArrayList<String> getCommonWords() {
		return mostCommonWords;
	}
	
	public String getCompleteFile() {
		return completeFile;
	}
	
	public String getNoPunctuation() {
		return noPunctuation;
	}
}
